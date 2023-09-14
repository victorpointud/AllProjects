
package proyectohotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ventana.Start;

/*
*   victorpointud, Juan2808, vicxandra
*/

public class Main {
    
    static RoomHistory history;
    static ReservationList reservations;
    static HashTable<String, RoomOwner> actualGuests;
    static LinkedList<RoomOwner> actualReservations;
   
    /*
     *  Se lee el excel y con esos datos se inicializa las estructuras, la tabla de hash tiene una 
     *  capacidad máxima de 300 ya que es el máximo de habitaciones.
     */
    
    public static void readExcel()throws IOException {
        history = new RoomHistory();
        reservations = new ReservationList();
        actualGuests = new HashTable<>(300);
        actualReservations = new LinkedList<>();
        File myFile = new File("./data/Booking_hotel.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
        DataFormatter dataFormatter = new DataFormatter();
        FormulaEvaluator evaluator = myWorkBook.getCreationHelper().createFormulaEvaluator();
        XSSFSheet reservasSheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = reservasSheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
           Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            String ci = dataFormatter.formatCellValue(cell).replaceAll(",", ".");
            cell = cellIterator.next();
            String nombre = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String segundo_nombre = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String email = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String genero = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String tipo_hab = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String celular = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String llegada = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String salida = dataFormatter.formatCellValue(cell, evaluator);
            Reservation reservation = new Reservation(ci, nombre, segundo_nombre, email, genero, tipo_hab, celular, llegada, salida);
            reservations.addReservation(reservation);
        }
        XSSFSheet habitacionesSheet = myWorkBook.getSheetAt(1);
        rowIterator = habitacionesSheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            String numHab = dataFormatter.formatCellValue(cell);
            history.addRoom(numHab);
        }
        
        int i = 1;
        XSSFSheet estadoSheet = myWorkBook.getSheetAt(2);
        for(Row row : estadoSheet) {         
            Cell cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String numHab = dataFormatter.formatCellValue(cell);
            if(numHab.equals("num_hab"))
                continue;
            cell = row.getCell(1);
            String nombre = dataFormatter.formatCellValue(cell);
            cell = row.getCell(2);
            String apellido = dataFormatter.formatCellValue(cell);
            cell = row.getCell(3);
            String email = dataFormatter.formatCellValue(cell);
            cell = row.getCell(4);
            String genero = dataFormatter.formatCellValue(cell);
            cell = row.getCell(5); 
            String celular = dataFormatter.formatCellValue(cell);
            cell = row.getCell(6); 
            String llegada = dataFormatter.formatCellValue(cell);
            RoomOwner ro = new RoomOwner(Integer.toString(i), nombre, apellido, email, genero, celular, llegada);
            if(numHab.equals("")){
                actualReservations.append(ro);
            } 
            else {
                actualGuests.put(nombre + " " + apellido, ro);
            }
            i++;
        }
        
        XSSFSheet historico = myWorkBook.getSheetAt(3);
        rowIterator = historico.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            String ci = dataFormatter.formatCellValue(cell).replaceAll(",", ".");
            cell = cellIterator.next();
            String nombre = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String apellido = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String email = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String genero = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String llegada = dataFormatter.formatCellValue(cell);
            cell = cellIterator.next();
            String numHab = dataFormatter.formatCellValue(cell);
            Guest c = new Guest(ci, nombre, apellido, email, genero, llegada);
            history.addRegister(numHab, c);
        }
    }
    
    public static void main(String[] args) {
        try {
            readExcel();
            Start fw = new Start(history, reservations, actualGuests, actualReservations);
            fw.setVisible(true);
        }
        catch(IOException e) {
            System.out.println("No se encontró el excel de entrada.");
        }
    }
    
}
