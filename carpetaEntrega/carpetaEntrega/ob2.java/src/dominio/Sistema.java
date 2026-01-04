    //Matias Regalo 308940 | Juan Constantin 335718
    package dominio;
    
    import java.io.Serializable;
    import java.util.*;
    //sistema veijo

    public class Sistema extends Observable implements Serializable{
    private List<Editorial> editoriales;
    private List<Genero> generos;
    private List<Autor> autores;
    private List<Libro> libros;
    private List<Venta> ventas;

        // Constructor
        public Sistema() {
        editoriales = new ArrayList<>();
        generos = new ArrayList<>();
        autores = new ArrayList<>();
        libros = new ArrayList<>();
        ventas = new ArrayList<>();
        }


        public void registrarEdit(String nombre, String paisDeOrigen) {
                editoriales.add(new Editorial(nombre, paisDeOrigen));
                setChanged();
                notifyObservers();
        }

          public void registrarGen(String nombre, String descripcion) {
                generos.add(new Genero(nombre, descripcion));
                setChanged();
                notifyObservers();
        }
            public void registrarAutor(String nombre, String nacionalidad, List<String> generos) {
                autores.add(new Autor(nombre, nacionalidad, generos));
                 setChanged();
                notifyObservers();

        }
            public void registrarLibro(String autor, String genero, String editorial, String isbn, String titulo, int precioDeCosto, int precioDeVenta, int stock) {
                    libros.add(new Libro(autor, genero, editorial, isbn, titulo, precioDeCosto, precioDeVenta, stock));
                    setChanged();
                    notifyObservers();
            }

            private int contadorFacturas = 1;
            public int obtenerySumarFactura() {
                return contadorFacturas++;
            }

            public int obtenerFacturaActual() {
                return contadorFacturas;
            }

    public Venta registrarVenta(String fecha, String nombreDelCliente, List<Libro> librosVendidos, List<Integer> cantidadesVendidas) {
     int factura = obtenerySumarFactura();  // Obtiene y aumenta el número de factura
     Venta nuevaVenta = new Venta(fecha, nombreDelCliente, factura);

     // Asociar los libros y cantidades a la venta
     for (int i = 0; i < librosVendidos.size(); i++) {
         nuevaVenta.agregarLibro(librosVendidos.get(i), cantidadesVendidas.get(i));
     }

     // Registrar la venta en la lista del sistema
     ventas.add(nuevaVenta);

     // Notificar cambios a los observadores
     setChanged();
     notifyObservers();

     return nuevaVenta; // Devolver la venta registrada por si se necesita
 }




        public boolean editUnico(String nombre) {
            for (Editorial e : editoriales) {
                if (e.getNombre().equalsIgnoreCase(nombre)) {
                    return false;
                }
            }
            return true;
        }

        public boolean genUnico(String nombre) {
            for (Genero g : generos) {
                if (g.getNombre().equalsIgnoreCase(nombre)) {
                    return false;
                }
            }
            return true;
        }

        public boolean autorUnico(String nombre) {
            for (Autor a : autores) {
                if (a.getNombre().equalsIgnoreCase(nombre)) {
                    return false;
                }
            }
            return true;
        }

        public boolean libroUnico(String isbn) {
            for (Libro l : libros) {
                if (l.getIsbn().equalsIgnoreCase(isbn)) {
                    return false;
                }
            }
            return true;
        }

        public boolean ventaUnico(int factura) {
            for (Venta v : ventas) {
                if (v.getFactura()==(factura)) {
                    return false;
                }
            }
            return true;
        }

        public  String[] getListaAutores() {
            String[] resultados = new String[autores.size()]; // Crear un arreglo de cadenas del tamaño de la lista

            for (int i = 0; i < autores.size(); i++) {
                resultados[i] = autores.get(i).toString(); // Llenar el arreglo con el resultado de toString()
            }
            return resultados; // Retornar el arreglo de cadenas
        }

        public List<Libro> getListaLibros() {
            return libros;
        }
        public List<Venta> getListaVentas() {
            return ventas;
        }
        public List<Editorial> getListaEditoriales() {
          return editoriales;
        } 
        public String[] getListaGeneros() {
            String[] resultados = new String[generos.size()]; // Crear un arreglo de cadenas del tamaño de la lista
            for (int i = 0; i < generos.size(); i++) {
                resultados[i] = generos.get(i).toString(); // Llenar el arreglo con el resultado de toString()
            }
            return resultados; // Retornar el arreglo de cadenas
        }

        public List<String> getAutoresPorGenero(String genero) {
            List<String> autoresFiltrados = new ArrayList<>();
            for (Autor autor : autores) {  // `autores` es la lista de todos los autores
                if (autor.escribeEnGenero(genero)) {  // Asegúrate de que Autor tiene este método
                    autoresFiltrados.add(autor.getNombre());
                }
            }
            return autoresFiltrados;
        }

        public int getPrecioLibroPorTitulo(String titulo) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    return libro.getPrecioDeVenta();
                }
            }
            return 0; // Si no se encuentra el libro, devuelve 0
        }

        public int getStockLibroPorTitulo(String titulo) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    return libro.getStock();
                }
            }
            return 0; // Si no se encuentra el libro, retornar 0
        }

        public Libro getLibroPorISBN(String isbn) {
            for (Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    return libro;
                }
            }
            return null; // Retorna null si no encuentra el libro
        }


        public void descontarStockLibroPorTitulo(String titulo, int cantidadVendida) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    int nuevoStock = libro.getStock() - cantidadVendida;
                    libro.setStock(nuevoStock);
                    break;
                }
            }
        }

        public int getPrecioLibro(String isbnTitulo) {
        for (Libro libro : libros) {
            if ((libro.getIsbn() + " - " + libro.getTitulo()).equals(isbnTitulo)) {
                return libro.getPrecioDeVenta();
            }
        }
        return 0;  // Retorna 0 si no se encuentra el libro (podrías manejar esto de otra forma)
    }


    public void eliminarVenta(int numeroFactura) {
        ventas.removeIf(venta -> venta.getFactura() == numeroFactura);
    }

    public void anularVenta(int numeroFactura) {
        Venta venta = getVentaPorNumeroFactura(numeroFactura);
        if (venta != null) {
            List<Libro> libros = venta.getLibrosVendidos();
            List<Integer> cantidades = venta.getCantidadesVendidas();

            for (int i = 0; i < libros.size(); i++) {
                Libro libro = libros.get(i);
                int cantidad = cantidades.get(i);
                libro.setStock(libro.getStock() + cantidad);
            }

            ventas.remove(venta);
            setChanged();
            notifyObservers();
        }
    }

    public List<Venta> getVentasPorISBN(String isbn) {
        List<Venta> ventasPorISBN = new ArrayList<>();

        for (Venta venta : ventas) {
            for (Libro libro : venta.getLibrosVendidos()) {
                if (libro.getIsbn().equals(isbn)) {
                    ventasPorISBN.add(venta);
                    break; // Una vez encontrada una coincidencia en esta venta, pasa a la siguiente venta
                }
            }
        }

        return ventasPorISBN;
    }


    public Venta getVentaPorNumeroFactura(int numeroFactura) {
        for (Venta venta : ventas) {
            if (venta.getFactura() == numeroFactura) {
                return venta;
            }
        }
        return null; // Retorna null si no encuentra la factura
    }

    }