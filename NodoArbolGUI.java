package com.mycompany.gestorbiblioteca;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NodoArbolGUI extends JFrame {
    private JTextArea outputTextArea;
    private JTextField inputTextField;
    private JButton addButton;
    private JButton searchButton;

    private NodoArbol nodoArbol;

    public NodoArbolGUI() {
        // Inicializar el árbol de libros
        nodoArbol = new NodoArbol();

        // Configurar la ventana
        setTitle("Gestor de Biblioteca");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        outputTextArea = new JTextArea(20, 20);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        inputTextField = new JTextField(20);
        addButton = new JButton("Agregar Libro");
        searchButton = new JButton("Buscar Libro");

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Título del Libro: "));
        inputPanel.add(inputTextField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Agregar el panel al frame
        add(panel);

        // Agregar eventos a los botones
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });
    }

    private void agregarLibro() {
        String titulo = inputTextField.getText();
        nodoArbol.agregarLibro(new Libro(titulo)); // Asume que Libro tiene un constructor con solo el título
        outputTextArea.append("Libro agregado: " + titulo + "\n");
        inputTextField.setText("");
    }

    private void buscarLibro() {
        String titulo = inputTextField.getText();
        Libro libro = nodoArbol.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            outputTextArea.append("Libro encontrado: " + libro.getTitulo() + "\n");
        } else {
            outputTextArea.append("Libro no encontrado.\n");
        }
        inputTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NodoArbolGUI NodoArbol = new NodoArbolGUI();
                NodoArbol.setVisible(false);
            }
        });
    }
}
