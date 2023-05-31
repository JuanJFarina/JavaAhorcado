import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.SystemColor;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.EventQueue;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class AhorcadoNumericoGUI
{
    private JFrame frmGenericGui;
    private JTextField textField;
    private JTextArea textArea;
    private JTextArea textArea_1;
    private static App ahorcado;
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final AhorcadoNumericoGUI window = new AhorcadoNumericoGUI();
                    window.frmGenericGui.setVisible(true);
                    AhorcadoNumericoGUI.access$1(new App());
                    AhorcadoNumericoGUI.ahorcado.setClave();
                    AhorcadoNumericoGUI.ahorcado.setGui(window);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public AhorcadoNumericoGUI() {
        this.initialize();
    }
    
    private void initialize() {
        (this.frmGenericGui = new JFrame()).setTitle("Generic GUI");
        this.frmGenericGui.setBounds(100, 100, 450, 300);
        this.frmGenericGui.setDefaultCloseOperation(3);
        this.frmGenericGui.getContentPane().setLayout(null);
        (this.textArea = new JTextArea()).setFocusable(false);
        this.textArea.setFont(new Font("Monospaced", 1, 10));
        this.textArea.setForeground(new Color(255, 255, 255));
        this.textArea.setToolTipText("Display Screen");
        this.textArea.setBackground(new Color(0, 0, 0));
        this.textArea.setBounds(10, 11, 254, 209);
        this.frmGenericGui.getContentPane().add(this.textArea);
        (this.textArea_1 = new JTextArea()).setLineWrap(true);
        this.textArea_1.setFocusable(false);
        this.textArea_1.setFont(new Font("Monospaced", 1, 10));
        this.textArea_1.setToolTipText("Help Screen");
        this.textArea_1.setText("\tAyuda\n+El n\u00famero secreto contiene 4 cifras, ning\u00fana mayor a 6\n+'x' significa que una cifra es correcta\n+'-' significa que una cifra esta en el lugar incorrecto\n+Escriba un n\u00famero");
        this.textArea_1.setBorder(new TitledBorder(null, "", 4, 2, null, null));
        this.textArea_1.setBackground(SystemColor.control);
        this.textArea_1.setBounds(274, 11, 150, 240);
        this.frmGenericGui.getContentPane().add(this.textArea_1);
        (this.textField = new JTextField()).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent arg0) {
                if (arg0.getKeyCode() == 10) {
                    final JTextField userInput = (JTextField)arg0.getComponent();
                    final String input = userInput.getText();
                    userInput.setText("");
                    AhorcadoNumericoGUI.CommandInterpreter(input);
                }
            }
        });
        this.textField.setFont(new Font("Tahoma", 1, 9));
        this.textField.setBounds(10, 231, 254, 20);
        this.frmGenericGui.getContentPane().add(this.textField);
        this.textField.setColumns(10);
    }
    
    public static void CommandInterpreter(final String input) {
        AhorcadoNumericoGUI.ahorcado.getGui().textArea.setText(AhorcadoNumericoGUI.ahorcado.validar(input));
    }
    
    static /* synthetic */ void access$1(final App ahorcado) {
        AhorcadoNumericoGUI.ahorcado = ahorcado;
    }
}
