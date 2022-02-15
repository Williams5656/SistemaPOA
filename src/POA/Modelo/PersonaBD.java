/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POA.Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author MIGUEL
 */
public class PersonaBD extends PersonaMD {

    Conect conectar = new Conect();

    public PersonaBD() {
    }

    public PersonaBD(String cedula, String nombres, String apellidos, String fecha_nacimiento, String direccion, String correo, String telefono, Image foto) {
        super(cedula, nombres, apellidos, fecha_nacimiento, direccion, correo, telefono, foto);
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        if (isThumbnail) {
            param.setSourceSubsampling(4, 4, 0, 0);
        }
        return reader.read(0, param);
    }

    public List<PersonaMD> mostrardatos() {

        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = "select * from persona Order by 1";
            ResultSet rs = conectar.query(sql);
            byte[] is;
            while (rs.next()) {
                PersonaMD p = new PersonaMD();
                p.setCedula(rs.getString("cedula"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setDireccion(rs.getString("direccion"));
                p.setCorreo(rs.getString("correo"));
                p.setTelefono(rs.getString("telefono"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

                is = rs.getBytes("foto");
                if (is != null) {
                    try {
                        is = Base64.decode(is, 0, rs.getBytes("foto").length);
//                    BufferedImage bi=Base64.decode( ImageIO.read(is));
                        p.setFoto(getImage(is, false));
                    } catch (Exception ex) {
                        p.setFoto(null);
                        Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    p.setFoto(null);
                }
                lista.add(p);
            }

            rs.close();
            return lista;
        } catch (Exception e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

    public boolean insertar() {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String nsql = "INSERT INTO personas(cedula,nombres,apellidos,fecha_nacimiento,direccion,correo,telefono,foto)" + "VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getFecha_nacimiento() + "','" + getDireccion() + "','" + getCorreo() + "','" + getTelefono() + "','" + ef + "')";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public boolean Modificar(String codigo) {
        String ef = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = toBufferedImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            ef = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        String nsql = "UPDATE personas set \"nombres\"='" + getNombres() + "',\"apellidos\"='" + getApellidos() + "',\"fecha_nacimiento\"='" + getFecha_nacimiento() + "',\"direccion\"='" + getDireccion() + "',\"correo\"='" + getCorreo() + "',\"telefono\"='" + getTelefono() + "',\"foto\"='" + ef + "'"
                + " where \"cedula\"='" + codigo + "'";

        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }
    
    public boolean eliminar(String codigo) {
        String nsql = "delete from personas where \"cedula\"='" + codigo + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("Error eliminar");
            return false;
        }
    }

}
