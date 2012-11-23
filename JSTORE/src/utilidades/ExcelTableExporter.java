 /*
    JSTORE is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package utilidades;

import java.io.*;
import javax.swing.*;
import jxl.write.*;
import jxl.*;

public class ExcelTableExporter {

    private File archivo;
    private JTable tabla;
    private String nombreTabla;

    public ExcelTableExporter(JTable tabla, File archivo, String nombreTabla) {
        this.archivo = archivo;
        this.tabla = tabla;
        this.nombreTabla = nombreTabla;
    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(archivo));
            WritableWorkbook w = Workbook.createWorkbook(out);
            WritableSheet s = w.createSheet(nombreTabla, 0);

            for (int i = 0; i < tabla.getRowCount(); i++) {
                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    Object objeto = tabla.getValueAt(i, j);
                    s.addCell(new Label(j,i, String.valueOf(objeto)));
                }
            }

            w.write();
            w.close();
            out.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
