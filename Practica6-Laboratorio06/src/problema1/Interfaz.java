package problema1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

public class Interfaz extends JFrame {
    private Biblioteca biblioteca;
    private JPanel mainPanel;
    private JTextArea areaLibros;
    private JTextArea areaAutores;
    private JTextArea areaEstudiantes;
    private JTextArea areaPrestamos;
    private JLabel lblEstadisticas;

    public Interfaz() {
        super("Gestor Bibliotecario v5.0");
        configurarVentana();
        cargarDatosPersistentes();
        inicializarComponentes();
        setVisible(true);
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Persistencia.guardarDatos(biblioteca);
            }
        });
    }

    private void cargarDatosPersistentes() {
        biblioteca = Persistencia.cargarDatos();
        if (biblioteca == null) {
            biblioteca = new Biblioteca("Biblioteca Central");
            cargarDatosDemo();
        }
        actualizarDatos();
    }

    private void inicializarComponentes() {
        mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 247, 250));

        JPanel panelSuperior = crearPanelAcciones();
        JPanel panelCentral = crearPanelInformacion();
        JPanel panelLateral = crearPanelEstadisticas();

        mainPanel.add(panelSuperior, BorderLayout.NORTH);
        mainPanel.add(panelCentral, BorderLayout.CENTER);
        mainPanel.add(panelLateral, BorderLayout.EAST);
        add(mainPanel);
    }

    private JPanel crearPanelAcciones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        String[] botones = {
            "\uD83D\uDCD5 Nuevo Libro",
            "\uD83E\uDDD1\u200D\uD83C\uDF93 Registrar Autor",
            "\uD83D\uDC64 Registrar Estudiante",
            "\uD83D\uDCE4 Realizar Préstamo",
            "\uD83D\uDCE5 Registrar Devolución"
        };

        for (String texto : botones) {
            JButton btn = new JButton(texto);
            estiloBotonAccion(btn);
            btn.addActionListener(this::manejarAcciones);
            panel.add(btn);
        }
        return panel;
    }

    private void estiloBotonAccion(JButton boton) {
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setPreferredSize(new Dimension(200, 45));
        boton.setBackground(new Color(240, 242, 245));
        boton.setForeground(new Color(60, 64, 67));
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(210, 214, 218)),
            BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        boton.setFocusPainted(false);
    }

    private JPanel crearPanelInformacion() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
        
        // Panel Libros
        JPanel panelLibros = new JPanel(new BorderLayout());
        panelLibros.setBorder(BorderFactory.createTitledBorder("\uD83D\uDCDA Libros"));
        areaLibros = new JTextArea();
        configurarAreaTexto(areaLibros);
        panelLibros.add(new JScrollPane(areaLibros), BorderLayout.CENTER);

        // Panel Autores
        JPanel panelAutores = new JPanel(new BorderLayout());
        panelAutores.setBorder(BorderFactory.createTitledBorder("\uD83E\uDDD1\u200D\uD83C\uDFDB️ Autores"));
        areaAutores = new JTextArea();
        configurarAreaTexto(areaAutores);
        panelAutores.add(new JScrollPane(areaAutores), BorderLayout.CENTER);

        // Panel Estudiantes
        JPanel panelEstudiantes = new JPanel(new BorderLayout());
        panelEstudiantes.setBorder(BorderFactory.createTitledBorder("\uD83D\uDC64 Estudiantes"));
        areaEstudiantes = new JTextArea();
        configurarAreaTexto(areaEstudiantes);
        panelEstudiantes.add(new JScrollPane(areaEstudiantes), BorderLayout.CENTER);

        // Panel Préstamos
        JPanel panelPrestamos = new JPanel(new BorderLayout());
        panelPrestamos.setBorder(BorderFactory.createTitledBorder("\uD83D\uDCC5 Préstamos"));
        areaPrestamos = new JTextArea();
        configurarAreaTexto(areaPrestamos);
        panelPrestamos.add(new JScrollPane(areaPrestamos), BorderLayout.CENTER);

        panel.add(panelLibros);
        panel.add(panelAutores);
        panel.add(panelEstudiantes);
        panel.add(panelPrestamos);
        return panel;
    }

    private void configurarAreaTexto(JTextArea area) {
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 13));
        area.setBackground(new Color(250, 250, 250));
        area.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    }

    private JPanel crearPanelEstadisticas() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 0));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Etiqueta de estadísticas
        lblEstadisticas = new JLabel(generarHTMLEstadisticas());
        lblEstadisticas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Botón de actualización con SwingWorker
        JButton btnActualizar = new JButton("\uD83D\uDD04 Actualizar Datos");
        estiloBotonAccion(btnActualizar);
        
        btnActualizar.addActionListener(e -> {
            btnActualizar.setEnabled(false);
            btnActualizar.setText("Actualizando...");
            
            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    try {
                        // Simular carga pesada
                        Thread.sleep(1000);
                        biblioteca.procesarActualizacion();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    return null;
                }

                @Override
                protected void done() {
                    SwingUtilities.invokeLater(() -> {
                        actualizarDatos();
                        btnActualizar.setEnabled(true);
                        btnActualizar.setText("\uD83D\uDD04 Actualizar Datos");
                        mostrarNotificacion("Datos actualizados correctamente", Color.decode("#4CAF50"));
                    });
                }
            }.execute();
        });

        // Panel contenedor del botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnActualizar);

        // Diseño final
        panel.add(lblEstadisticas, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);

        return panel;
    }

    // Método auxiliar para notificaciones
    private void mostrarNotificacion(String mensaje, Color colorFondo) {
        JLabel lblNotificacion = new JLabel(mensaje);
        lblNotificacion.setOpaque(true);
        lblNotificacion.setBackground(colorFondo);
        lblNotificacion.setForeground(Color.WHITE);
        lblNotificacion.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JOptionPane optionPane = new JOptionPane(lblNotificacion, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(this, "Notificación");
        dialog.setVisible(true);
        
        new Timer(2000, evt -> dialog.dispose()).start();
    }


    private String generarHTMLEstadisticas() {
        return String.format("<html><div style='padding:10px; color:#333'>" +
            "<h3 style='color:#2c3e50; margin-top:0'>\uD83D\uDCCA Estadísticas</h3>" +
            "<p>\uD83D\uDCDA Libros: %d</p>" +
            "<p>\uD83E\uDDD1\u200D\uD83C\uDFDB️ Autores: %d</p>" +
            "<p>\uD83D\uDC64 Estudiantes: %d</p>" +
            "<p>\uD83D\uDCE4 Préstamos: %d</p>" +
            "<hr>" +
            "<p style='color:#2c3e50; font-weight:bold'>Total registros: %d</p>" +
            "<p>⏳ Actualizado: %s</p>" +
            "</div></html>",
            biblioteca.getLibrosDisponibles().size(),
            biblioteca.getAutoresRegistrados().size(),
            biblioteca.getEstudiantesRegistrados().size(),
            biblioteca.getPrestamosActivos().size(),
            biblioteca.getLibrosDisponibles().size() + 
            biblioteca.getAutoresRegistrados().size() + 
            biblioteca.getEstudiantesRegistrados().size() + 
            biblioteca.getPrestamosActivos().size(),
            LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private void manejarAcciones(ActionEvent e) {
        String accion = ((JButton) e.getSource()).getText();
        switch(accion) {
            case "\uD83D\uDCD5 Nuevo Libro":
                mostrarDialogoLibro();
                break;
            case "\uD83E\uDDD1\u200D\uD83C\uDF93 Registrar Autor":
                mostrarDialogoAutor();
                break;
            case "\uD83D\uDC64 Registrar Estudiante":
                mostrarDialogoEstudiante();
                break;
            case "\uD83D\uDCE4 Realizar Préstamo":
                mostrarDialogoPrestamo();
                break;
            case "\uD83D\uDCE5 Registrar Devolución":
                mostrarDialogoDevolucion();
                break;
        }
    }

    private void mostrarDialogoLibro() {
        JDialog dialogo = new JDialog(this, "Registro de Libro", true);
        dialogo.setSize(500, 350);
        dialogo.setLayout(new BorderLayout(10, 10));

        JPanel panelContenido = new JPanel(new GridLayout(5, 2, 15, 15));
        panelContenido.setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextField txtTitulo = crearCampoTexto();
        JTextField txtISBN = crearCampoTexto();
        JTextField txtStock = crearCampoTexto();
        JComboBox<Autor> comboAutores = new JComboBox<>();

        biblioteca.getAutoresRegistrados().forEach(comboAutores::addItem);

        if(comboAutores.getItemCount() == 0) {
            mostrarError(dialogo, "Primero registre al menos un autor");
            dialogo.dispose();
            return;
        }

        panelContenido.add(new JLabel("Título:"));
        panelContenido.add(txtTitulo);
        panelContenido.add(new JLabel("ISBN:"));
        panelContenido.add(txtISBN);
        panelContenido.add(new JLabel("Stock Inicial:"));
        panelContenido.add(txtStock);
        panelContenido.add(new JLabel("Autor:"));
        panelContenido.add(comboAutores);

        JButton btnRegistrar = new JButton("Registrar Libro");
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrar.addActionListener(e -> {
            if(txtTitulo.getText().isEmpty() || txtISBN.getText().isEmpty()) {
                mostrarError(dialogo, "Complete todos los campos");
                return;
            }
            try {
                int stock = Integer.parseInt(txtStock.getText());
                if(stock <= 0) throw new NumberFormatException();
                
                Autor autor = (Autor) comboAutores.getSelectedItem();
                biblioteca.agregarLibro(new Libro(
                    txtTitulo.getText().trim(), 
                    txtISBN.getText().trim(), 
                    stock,
                    autor
                ));
                actualizarDatos();
                dialogo.dispose();
                
            } catch(NumberFormatException ex) {
                mostrarError(dialogo, "Stock debe ser un número mayor a 0");
            }
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.setBorder(new EmptyBorder(0, 20, 20, 20));
        panelBoton.add(btnRegistrar);

        dialogo.add(panelContenido, BorderLayout.CENTER);
        dialogo.add(panelBoton, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarDialogoAutor() {
        JDialog dialogo = new JDialog(this, "Registro de Autor", true);
        dialogo.setSize(450, 300);
        dialogo.setLayout(new BorderLayout(10, 10));

        JPanel panelContenido = new JPanel(new GridLayout(4, 2, 15, 15));
        panelContenido.setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextField txtNombre = crearCampoTexto();
        JTextField txtNacionalidad = crearCampoTexto();
        JTextField txtFechaNac = crearCampoTexto();

        panelContenido.add(new JLabel("Nombre:"));
        panelContenido.add(txtNombre);
        panelContenido.add(new JLabel("Nacionalidad:"));
        panelContenido.add(txtNacionalidad);
        panelContenido.add(new JLabel("Fecha Nac. (dd/MM/yyyy):"));
        panelContenido.add(txtFechaNac);

        JButton btnRegistrar = new JButton("Registrar Autor");
        btnRegistrar.addActionListener(e -> {
            try {
                LocalDate fecha = LocalDate.parse(txtFechaNac.getText(), 
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                
                biblioteca.registrarAutor(new Autor(
                    txtNombre.getText().trim(),
                    txtNacionalidad.getText().trim(),
                    fecha
                ));
                actualizarDatos();
                dialogo.dispose();
                
            } catch(Exception ex) {
                mostrarError(dialogo, "Formato fecha inválido (usar dd/MM/yyyy)");
            }
        });

        dialogo.add(panelContenido, BorderLayout.CENTER);
        dialogo.add(btnRegistrar, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }
    private void mostrarError(JDialog parent, String mensaje) {
        JLabel lblError = new JLabel(mensaje);
        lblError.setForeground(Color.RED);
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        
        JOptionPane.showMessageDialog(
            parent,
            lblError,
            "Error de validación",
            JOptionPane.ERROR_MESSAGE
        );
    }

    private void mostrarDialogoEstudiante() {
        JDialog dialogo = new JDialog(this, "Registro de Estudiante", true);
        dialogo.setSize(400, 250);
        dialogo.setLayout(new BorderLayout(10, 10));

        JPanel contenido = new JPanel(new GridLayout(0, 1, 5, 5));
        

        JTextField txtCodigo = crearCampoTexto();
        JTextField txtNombre = crearCampoTexto();

        contenido.add(new JLabel("Código:"));
        contenido.add(txtCodigo);
        contenido.add(new JLabel("Nombre completo:"));
        contenido.add(txtNombre);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();

            if (codigo.isEmpty() || nombre.isEmpty()) {
            	mostrarError(dialogo, "Ambos campos son obligatorios");
                return;
            }

            if (biblioteca.getEstudiantesRegistrados().stream()
                .anyMatch(est -> est.getCodigo().equalsIgnoreCase(codigo))) {
            mostrarError(dialogo, "El código ya está registrado");
                return;
            }

            Estudiante nuevo = new Estudiante(codigo, nombre);
            biblioteca.registrarEstudiante(nuevo);
            actualizarDatos();
            dialogo.dispose();
        });

        contenido.add(btnRegistrar);
        dialogo.add(contenido);
        dialogo.pack();
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarDialogoPrestamo() {
        JDialog dialogo = new JDialog(this, "Registrar Préstamo", true);
        dialogo.setSize(500, 300);
        dialogo.setLayout(new BorderLayout(10, 10));

        JPanel panelContenido = new JPanel(new GridLayout(4, 2, 15, 15));
        panelContenido.setBorder(new EmptyBorder(20, 20, 20, 20));

        JComboBox<Libro> comboLibros = new JComboBox<>();
        JComboBox<Estudiante> comboEstudiantes = new JComboBox<>();
        JTextField txtCantidad = crearCampoTexto();

        biblioteca.getLibrosDisponibles().forEach(comboLibros::addItem);
        biblioteca.getEstudiantesRegistrados().forEach(comboEstudiantes::addItem);

        if(comboLibros.getItemCount() == 0 || comboEstudiantes.getItemCount() == 0) {
            mostrarError(dialogo, "Registre al menos 1 libro y 1 estudiante primero");
            dialogo.dispose();
            return;
        }

        panelContenido.add(new JLabel("Libro:"));
        panelContenido.add(comboLibros);
        panelContenido.add(new JLabel("Estudiante:"));
        panelContenido.add(comboEstudiantes);
        panelContenido.add(new JLabel("Cantidad:"));
        panelContenido.add(txtCantidad);

        JButton btnRegistrar = new JButton("Registrar Préstamo");
        btnRegistrar.addActionListener(e -> {
            try {
                Libro libro = (Libro) comboLibros.getSelectedItem();
                Estudiante estudiante = (Estudiante) comboEstudiantes.getSelectedItem();
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                
                if(cantidad <= 0) throw new NumberFormatException();
                if(libro.getStock() < cantidad) {
                    mostrarError(dialogo, "Stock insuficiente");
                    return;
                }
                
                biblioteca.realizarPrestamo(libro, estudiante, cantidad);
                actualizarDatos();
                dialogo.dispose();
                
            } catch(NumberFormatException ex) {
                mostrarError(dialogo, "Cantidad inválida");
            }
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnRegistrar);

        dialogo.add(panelContenido, BorderLayout.CENTER);
        dialogo.add(panelBoton, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarDialogoDevolucion() {
        JDialog dialogo = new JDialog(this, "Registrar Devolución", true);
        dialogo.setSize(500, 250);
        dialogo.setLayout(new BorderLayout(10, 10));

        JPanel panelContenido = new JPanel(new GridLayout(3, 2, 15, 15));
        panelContenido.setBorder(new EmptyBorder(20, 20, 20, 20));

        JComboBox<Prestamo> comboPrestamos = new JComboBox<>();
        biblioteca.getPrestamosActivos().forEach(comboPrestamos::addItem);

        if(comboPrestamos.getItemCount() == 0) {
            mostrarError(dialogo, "No hay préstamos activos");
            dialogo.dispose();
            return;
        }

        panelContenido.add(new JLabel("Préstamo Activo:"));
        panelContenido.add(comboPrestamos);

        JButton btnDevolver = new JButton("Registrar Devolución");
        btnDevolver.addActionListener(e -> {
            Prestamo prestamo = (Prestamo) comboPrestamos.getSelectedItem();
            biblioteca.registrarDevolucion(prestamo);
            actualizarDatos();
            dialogo.dispose();
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnDevolver);

        dialogo.add(panelContenido, BorderLayout.CENTER);
        dialogo.add(panelBoton, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField();
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return campo;
    }

    private void mostrarError(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void actualizarDatos() {
        SwingUtilities.invokeLater(() -> {
            actualizarListadoLibros();
            actualizarListadoAutores();
            lblEstadisticas.setText(generarHTMLEstadisticas());
        });
    }

    private void actualizarListadoLibros() {
        areaLibros.setText("");
        biblioteca.getLibrosDisponibles().stream()
            .sorted(Comparator.comparing(Libro::getTitulo))
            .forEach(libro -> areaLibros.append(
                String.format("▸ %-25s\n ISBN: %s | Autor: %s | Stock: %d\n\n", 
                    libro.getTitulo(), 
                    libro.getIsbn(),
                    libro.getAutor().getNombre(),
                    libro.getStock())
            ));
    }

    private void actualizarListadoAutores() {
        areaAutores.setText("");
        biblioteca.getAutoresRegistrados().stream()
            .sorted(Comparator.comparing(Autor::getNombre))
            .forEach(autor -> areaAutores.append(
                String.format("▸ %s (%s)\n Nac: %s\n\n",
                    autor.getNombre(),
                    autor.getNacionalidad(),
                    autor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
                )
            ));
    }

    private void actualizarListadoEstudiantes() {
        areaEstudiantes.setText("");
        biblioteca.getEstudiantesRegistrados().stream()
            .sorted(Comparator.comparing(Estudiante::getNombre))
            .forEach(est -> areaEstudiantes.append(
                String.format("▸ %s\n Código: %s\n Fecha Registro: %s\n\n",
                    est.getNombre(),
                    est.getCodigo(),
                    LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                )
            ));
    }


    private void actualizarListadoPrestamos() {
        areaPrestamos.setText("");
        biblioteca.getPrestamosActivos().stream()
            .sorted(Comparator.comparing(Prestamo::getFechaPrestamo))
            .forEach(p -> areaPrestamos.append(
                String.format("▸ %s\n Libro: %s\n Estudiante: %s\n Devuelto: %s\n\n",
                    p.getFechaPrestamo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    p.getLibro().getTitulo(),
                    p.getEstudiante().getNombre(),
                    p.getFechaDevolucion() != null ? "Sí" : "No"
                )
            ));
    }


    private void cargarDatosDemo() {
        try {
            // Autores demo
            Autor gabo = new Autor("Gabriel García Márquez", "Colombiano", LocalDate.of(1927, 3, 6));
            Autor cortazar = new Autor("Julio Cortázar", "Argentino", LocalDate.of(1914, 8, 26));
            biblioteca.registrarAutor(gabo);
            biblioteca.registrarAutor(cortazar);

            // Libros demo
            biblioteca.agregarLibro(new Libro("Cien años de soledad", "978-0307474728", 5, gabo));
            biblioteca.agregarLibro(new Libro("Rayuela", "978-8437604947", 3, cortazar));
            
            // Estudiantes demo
            biblioteca.registrarEstudiante(new Estudiante("2023-001", "Juan Pérez"));
            biblioteca.registrarEstudiante(new Estudiante("2023-002", "María García"));
            
            // Préstamo demo
            Libro libroDemo = biblioteca.getLibrosDisponibles().get(0);
            Estudiante estudianteDemo = biblioteca.getEstudiantesRegistrados().get(0);
            biblioteca.realizarPrestamo(libroDemo, estudianteDemo, 2);
        } catch(Exception e) {
            mostrarError(this, "Error cargando datos demo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                new Interfaz();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Error inicializando: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
