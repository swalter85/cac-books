package com.ar.apibooks;

public class books {
    private long idlibro;
    private String titulo;
    private String autor;
    private String genero;
    private String editorial;
    private String imagen;
    private String descripcion;

    public books() {

    }

    public books(long idlibro, String titulo, String autor, String genero ,String editorial, String imagen, String descripcion) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }


    
    public long getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(long idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero () {
        return genero;
    }

    public void setGenero (String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "books [idlibro=" + idlibro + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
                + ", editorial=" + editorial + ", imagen=" + imagen + ", descripcion=" + descripcion + "]";
    }

    
    
    
}
