# Llamado a datos
.data

input: .asciiz "\nIngresa un número decimal: "
selection: .asciiz "\nSelecciona a qué lo quieres transformar: \n \n 1. Binario. \n 2. Hexadecimal. \n 3. Decimal Empaquetado. \n 4. Octal. \n 5. Base 10. \n 6. Salir. \n"
output_bin: .asciiz "\nBinario: "
output_hex: .asciiz "\nHexadecimal: "
output_bcd: .asciiz "\nDecimal Empaquetado: "
output_oct: .asciiz "\nOctal: "
output_base10: .asciiz "\nBase 10: "

invalid_input: .asciiz "\nEntrada inválida. Inténtalo de nuevo.\n"
invalid_selection: .asciiz "\nSelección inválida. Inténtalo de nuevo.\n"

binary: .space 33       # Espacio para 32 bits binarios + terminador nulo
hexadecimal: .space 9   # Espacio para 8 dígitos hexadecimales + terminador nulo
bcd: .space 17          # Espacio para 16 dígitos BCD + terminador nulox
octal: .space 12        # Espacio para 11 dígitos octales + terminador nulo
base10: .space 20       # Espacio para 11 caracteres más el terminador nulo
temp: .space 12         # Espacio temporal para almacenar los dígitos
buffer: .space 20       # Espacio para el número convertido y el terminador nulo

# Llamado a funciones globales
.text
.globl main

# Macro para convertir decimal a decimal empaquetado
.macro DEC_TO_BCD
    la $t0, bcd  
    move $t1, $a0       
    move $t7, $a1      

    # Convertir binario a decimal si es binario
    beqz $t7, skip_binary_conversion
    li $t3, 0          
    li $t4, 1         

    # Transformacion de binario a decimal
    binary_to_decimal:
    	beqz $t1, binary_conversion_done
    	andi $t5, $t1, 1   
    	mul $t5, $t5, $t4  
    	add $t3, $t3, $t5  
    	srl $t1, $t1, 1    
    	j binary_to_decimal

    # Terminar conversion binaria	
    binary_conversion_done:
    	move $t1, $t3

    # Punto de inicio del buffer temporal	
    skip_binary_conversion:
    	li $t3, 10
    	la $t4, temp       
    	addi $t4, $t4, 11  
    	move $t5, $t4    

    # Convertir a decimal empaquetado
    convert_to_bcd:
    	beqz $t1, finish_convert
    	div $t1, $t3
    	mfhi $t6          
    	addi $t6, $t6, 0x30 
    	sb $t6, 0($t5)    
    	subi $t5, $t5, 1  
    	mflo $t1          
    	j convert_to_bcd

    # Terminar conversion
    finish_convert:
    	la $t4, temp
   	move $t8, $t0
    	li $t9, 0x0      

    # Ralizar el pack de decimal empaquetado
    pack_bcd:
    	lb $t6, 0($t4)
    	beqz $t6, done
    	sll $t9, $t9, 4   
    	or $t9, $t9, $t6  
    	lb $t6, 1($t4)
    	beqz $t6, finish_pack
    	sll $t9, $t9, 4   
    	or $t9, $t9, $t6  
    	sb $t9, 0($t8)    
    	addi $t8, $t8, 1  
    	li $t9, 0x0       
    	addi $t4, $t4, 2  
    	j pack_bcd

    # Almacenar el último byte BCD si es necesario
    finish_pack:
    	sb $t9, 0($t8)    

    # Terminar la cadena con nulo
    done:
    	sb $zero, 0($t8) 

.end_macro


# Macro para convertir decimal a base 10
.macro DEC_TO_10
    la $t0, base10    
    move $t1, $a0      
    move $t7, $a1
    beqz $t7, skip_binary_conversion
    li $t3, 0          
    li $t4, 1          
    
    # Convertir binario a decimal si es binario
    binary_to_decimal:
    	beqz $t1, binary_conversion_done
    	andi $t5, $t1, 1  
    	mul $t5, $t5, $t4  
    	add $t3, $t3, $t5  
    	srl $t1, $t1, 1   
    	mul $t4, $t4, 2    
    	j binary_to_decimal
    	
     # Terminar conversión
    binary_conversion_done:
    	move $t1, $t3

    skip_binary_conversion:
   	
   	# Determinar el signo del número
    	bltz $t1, negative
    	li $t2, 43  # '+'
    	sb $t2, 0($t0)
    	addi $t0, $t0, 1
    	j positive

    	# Verificar si es negativo
    	negative:
        	li $t2, 45 # '-'
        	sb $t2, 0($t0)
        	addi $t0, $t0, 1
        	negu $t1, $t1
        
    	# Convertir el número positivo a su representación en base 10
    	positive:
        	li $t3, 10
        	la $t4, temp       
        	addi $t4, $t4, 11  
        	move $t5, $t4
        
    	# Bucle de conversión de dígitos
    	convert_loop:
        	beqz $t1, finish_convert
        	div $t1, $t3
        	mfhi $t6           
        	addi $t6, $t6, 48  
        	subi $t5, $t5, 1   
        	sb $t6, 0($t5)     
        	mflo $t1          
        	j convert_loop
        
    	# Finalizar conversión
    	finish_convert:
        	la $t4, temp
    
    	# Copiar los dígitos del temporal a la salida
    	copy_loop:
        	lb $t6, 0($t5)
        	beqz $t6, done
        	sb $t6, 0($t0)
        	addi $t0, $t0, 1
        	addi $t5, $t5, 1
        	j copy_loop

    	# Terminar la cadena con nulo
    	done:
        	sb $zero, 0($t0)

.end_macro

# Macro para convertir decimal a binario complemento a 2
.macro DEC_TO_BIN
    li $t0, 32                
    move $t1, $a0             
    la $a1, binary           

    # Convertir el número decimal a su representación binaria 
    bin_loop:
        beqz $t0, bin_done    
        andi $t2, $t1, 1      
        addi $t2, $t2, 48     
        sub $t0, $t0, 1       
        sb $t2, 0($a1)        
        addi $a1, $a1, 1     
        sra $t1, $t1, 1      
        j bin_loop
    
    # Agrega el terminador nulo
    bin_done:
        sb $zero, 0($a1)      
        la $a0, binary        
        addi $a1, $a1, -1     
        la $t3, binary        
        move $t4, $a1         

    # Invierte la cadena binaria
    reverse_loop:
        bge $t3, $t4, reverse_done
        lb $t5, 0($t3)
        lb $t6, 0($t4)
        sb $t6, 0($t3)
        sb $t5, 0($t4)
        addi $t3, $t3, 1
        subi $t4, $t4, 1
        j reverse_loop

    # Fin reverse_loop
    reverse_done:
    
.end_macro

# Macro para convertir decimal a hexadecimal
.macro DEC_TO_HEX
    la $t0, hexadecimal    
    move $t2, $a0      

    bltz $t2, negative
    li $t1, 43  # '+'
    sb $t1, 0($t0)
    j hex_start

    # Verifica si es negativo
    negative:
        li $t1, 45  # '-'
        sb $t1, 0($t0)
        negu $t2, $t2 

    # Convierte de decimal a hexadecimal 
    hex_start:
        addi $t0, $t0, 1  
        li $t3, 8 
        la $t4, hexadecimal + 1  

    # Extrae 4 bits del número y los convierte en el carácter hexadecimal
    hex_loop:
        beqz $t3, hex_done
        rol $t2, $t2, 4  
        and $t5, $t2, 0xf  
        ble $t5, 9, hex_digit
        addi $t5, $t5, 55  
        j hex_store
        
    # Convierte este valor a su carácter ASCII correspondiente
    hex_digit:
        addi $t5, $t5, 48  
        
    # Almacena el carácter convertido en la cadena
    hex_store:
        sb $t5, 0($t4)  
        addi $t4, $t4, 1  
        addi $t3, $t3, -1  
        j hex_loop

    # Agrega el terminador nulo
    hex_done:
        sb $zero, 0($t4)  
        
.end_macro

# Macro para convertir decimal a octal
.macro DEC_TO_OCT
    la $t0, octal       
    move $t1, $a0        
    
    bltz $t1, negative
    li $t2, 43  # '+'
    sb $t2, 0($t0)
    addi $t0, $t0, 1
    j positive

    # Verificar si es negativo
    negative:
        li $t2, 45  # '-'
        sb $t2, 0($t0)
        addi $t0, $t0, 1
        negu $t1, $t1
    
    # Convertir el número positivo a su representación en octal
    positive:
        li $t3, 8
        la $t4, temp
        addi $t4, $t4, 11
        move $t5, $t4

    # Bucle de conversión de dígitos
    convert_loop:
        beqz $t1, finish_convert    
        div $t1, $t3
        mfhi $t6            
        addi $t6, $t6, 48   
        subi $t5, $t5, 1  
        sb $t6, 0($t5)     
        mflo $t1          
        j convert_loop
        
    # Finalizar conversión
    finish_convert:
        la $t4, temp       

    # Copiar los dígitos del temporal a la salida octal
    copy_loop:
        lb $t6, 0($t5)
        beqz $t6, done       
        sb $t6, 0($t0)
        addi $t0, $t0, 1
        addi $t5, $t5, 1
        j copy_loop
        
    # Terminar la cadena con nulo
    done:
        sb $zero, 0($t0)  

.end_macro


# Llamada a main
main:

    # Mostrar mensaje de entrada
    li $v0, 4
    la $a0, input
    syscall

    # Leer el número decimal
    li $v0, 5
    syscall
    move $t1, $v0 

    j continue_program

    # Continuar con el programa si la entrada es válida
    continue_program:
        li $v0, 4
        la $a0, selection
        syscall

        # Leer la selección del usuario
        li $v0, 5
        syscall
        move $t0, $v0 

        # Verificar si la selección es inválida (fuera del rango 1-6)
        blt $t0, 1, selection_error
        bgt $t0, 6, selection_error

        # Dependiendo de la selección, llamar a la macro correspondiente
        li $t2, 1
        beq $t0, $t2, call_bin

        li $t2, 2
        beq $t0, $t2, call_hex

        li $t2, 5
        beq $t0, $t2, call_base10

        li $t2, 3
        beq $t0, $t2, call_bcd

        li $t2, 4
        beq $t0, $t2, call_oct

    j exit_program

    # Reiniciar el programa o manejar el error adecuadamente
    input_error:
        li $v0, 4
        la $a0, invalid_input
        syscall
        j main
        
    # Reiniciar el programa o manejar el error adecuadamente
    selection_error:
        li $v0, 4
        la $a0, invalid_selection
        syscall
        j main 
    
    # Llamado a macro para convertir decimal a base 10
    call_base10:
        move $a0, $t1
        DEC_TO_10
        li $v0, 4
        la $a0, output_base10
        syscall
        li $v0, 4
        la $a0, base10
        syscall
        j exit_program

    # Llamado a macro para convertir decimal a binario complemento a 2
    call_bin:
        move $a0, $t1
        DEC_TO_BIN
        li $v0, 4
        la $a0, output_bin
        syscall
        li $v0, 4
        la $a0, binary
        syscall
        j exit_program

    # LLamado a macro para convertir decimal a hexadecimal
    call_hex:
        move $a0, $t1
        DEC_TO_HEX
        li $v0, 4
        la $a0, output_hex
        syscall
        li $v0, 4
        la $a0, hexadecimal
        syscall
        j exit_program
    
    # Llamado a macro para convertir decimal a Decimal Empaquetado (BCD)
    call_bcd:
        move $a0, $t1
        DEC_TO_BCD
        li $v0, 4
        la $a0, output_bcd
        syscall
        li $v0, 4
        la $a0, bcd_result
        syscall
        j exit_program
        
    # Llamado a macro para convertir decimal a octal
    call_oct:
        move $a0, $t1
        DEC_TO_OCT
        li $v0, 4
        la $a0, output_oct
        syscall
        li $v0, 4
        la $a0, octal
        syscall
        j exit_program

    # Salir del programa
    exit_program:
        li $v0, 10
        syscall
