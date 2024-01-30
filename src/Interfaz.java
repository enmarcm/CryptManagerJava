import encrypt.CryptManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Interfaz {
    public JPanel Panel;
    private JTextArea textAreaPublicKey;
    private JButton botonSubmit;
    private JFileChooser archivoACifrar;
    private JFileChooser archivoDestino;
    private JTextArea textoInfo;
    private JFileChooser fileChooser;

    public Interfaz() {
        JFrame frame = new JFrame("Cifrado");
        frame.setContentPane(Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setIconImage(new ImageIcon("src/img.png").getImage());
        frame.setVisible(true);

        botonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String publicKey = textAreaPublicKey.getText();
                    File selectedFile = archivoACifrar.getSelectedFile();
                    File selectedOut = archivoDestino.getSelectedFile();

                    if (selectedFile == null || publicKey == null) {
                        throw new Exception("No se ha seleccionado un archivo o no se ha ingresado la llave publica");
                    }

                    String pathFile = selectedFile.getAbsolutePath();
                    String pathOut;
                    if (selectedOut == null) {
                        // Si selectedOut es null, crea un nuevo archivo en el mismo directorio que selectedFile
                        pathOut = selectedFile.getParent() + File.separator + "cifrado.txt";
                    } else {
                        pathOut = selectedOut.getAbsolutePath();
                    }

                    CryptManager cm = new CryptManager();
                    cm.encryptFile(pathFile, publicKey, pathOut);

                    JOptionPane.showMessageDialog(null, "Archivo cifrado con exit en la ruta " + pathOut);

                    //Reiniciar los valores
                    resetValues();

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    resetValues();

                }
            }
        });

        addClickSelect(archivoACifrar);

        addClickSelect(archivoDestino);
    }

    private void addClickSelect(JFileChooser fileChooser) {
        fileChooser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    fileChooser.approveSelection();
                }
            }
        });

        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Aquí puedes hacer lo que necesites con el archivo seleccionado
                } else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
                    System.out.println("Cancelado");
                }
            }
        });
    }

    private void resetValues() {
        textAreaPublicKey.setText("");
        archivoACifrar.setSelectedFile(null);
        archivoDestino.setSelectedFile(null);
    }
}
