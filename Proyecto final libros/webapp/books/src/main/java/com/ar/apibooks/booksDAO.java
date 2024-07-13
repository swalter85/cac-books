package com.ar.apibooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class booksDAO {

    public long insertlibro(books libro) {
        databaseconexion conexion = new databaseconexion();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection cn = conexion.conectar();
        long idNuevoLibro = -1;

        String insertarLibroSql = "INSERT INTO books(titulo, autor, genero, editorial, imagen, descripcion) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            pstm = cn.prepareStatement(insertarLibroSql, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, libro.getTitulo());
            pstm.setString(2, libro.getAutor());
            pstm.setString(3, libro.getGenero());
            pstm.setString(4, libro.getEditorial());
            pstm.setString(5, libro.getImagen());
            pstm.setString(6, libro.getDescripcion());

            int result = pstm.executeUpdate();

            if (result > 0) {
                rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println("Se cargó exitosamente un nuevo libro");
                    idNuevoLibro = rs.getLong(1);
                } else {
                    System.out.println("Error al obtener ID del libro insertado");
                }
            } else {
                System.out.println("Error al insertar el libro");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return idNuevoLibro;
    }

    public List<books> get_All_Libros() {
        databaseconexion conexion = new databaseconexion();
        Connection cn = conexion.conectar();
        List<books> libros = new ArrayList<>();

        PreparedStatement pstm = null;
        ResultSet rs = null;

        String selectLibroSql = "SELECT * FROM books";
        try {
            pstm = cn.prepareStatement(selectLibroSql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Long idlibro = rs.getLong("id");
                String tit = rs.getString("titulo");
                String aut = rs.getString("autor");
                String gen = rs.getString("genero");
                String edi = rs.getString("editorial");
                String img = rs.getString("imagen");
                String desc = rs.getString("descripcion");

                books libro = new books(idlibro, tit, aut, gen, edi, img, desc);
                libros.add(libro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return libros;
    }
}
