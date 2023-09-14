
saldo_inicial = 3480

print("Saldo actual a la fecha [2020/04/10]: $",saldo_inicial)

print("Se han retidado $ 96 de tu cuenta por tienda de ropa")

saldo_restante = saldo_inicial - 96
print("Saldo actual a la fecha [2020/04/11]: $",saldo_restante)

print("Se han agregado $ 1200 a tu cuenta por cobro de salario")

saldo_añadido = saldo_restante + 1200
print("Saldo actual a la fecha [2020/04/17]: $",saldo_añadido)

print("Se ha retirado el 3% del saldo de su cuenta por intereses")

interes = saldo_añadido * (3/100) 

saldo_por_interes = saldo_añadido - interes
print("Saldo actual a la fecha [2020/04/30]: $",saldo_por_interes)

print("Se han retirado $ 51 de tu cuenta por compra en supermercado")

saldo_por_supermercado = saldo_por_interes - 51
print("Saldo actual a la fecha [2020/05/02]: $",saldo_por_supermercado)

saldo_total = saldo_por_supermercado
print("Su saldo total al finalizar queda en $", saldo_total)