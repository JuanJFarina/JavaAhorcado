// 
// Decompiled by Procyon v0.5.36
// 

public class App
{
    private AhorcadoNumericoGUI gui;
    private String clave;
    private String respuesta;
    private boolean[] correctos;
    
    public App() {
        this.clave = "";
        this.correctos = new boolean[4];
    }
    
    public AhorcadoNumericoGUI getGui() {
        return this.gui;
    }
    
    public void setGui(final AhorcadoNumericoGUI gui) {
        this.gui = gui;
    }
    
    public void setClave() {
        for (int i = 0; i < 4; ++i) {
            this.clave = String.valueOf(this.clave) + (int)(Math.random() * 6.0);
        }
    }
    
    public String validar(final String input) {
        this.respuesta = "";
        this.correctos[0] = false;
        this.correctos[1] = false;
        this.correctos[2] = false;
        this.correctos[3] = false;
        return this.validarExactos(input);
    }
    
    public String validarExactos(final String string) {
        int flag = 0;
        for (int i = 0; i < 4; ++i) {
            if (string.charAt(i) == this.clave.charAt(i)) {
                this.respuesta = String.valueOf(this.respuesta) + "x ";
                this.correctos[i] = true;
                ++flag;
            }
            if (flag == 4) {
                return this.respuesta = "Correcto !";
            }
        }
        if (flag != 4) {
            return this.validarSimilares(string);
        }
        return null;
    }
    
    public String validarSimilares(final String string) {
        for (int i = 0; i < 4; ++i) {
            if (!this.correctos[i]) {
                boolean repetido = false;
                for (int y = i - 1; y >= 0; --y) {
                    if (string.charAt(y) == string.charAt(i)) {
                        repetido = true;
                    }
                }
                if (!repetido) {
                    for (int x = 0; x < 4; ++x) {
                        if (!this.correctos[x]) {
                            if (string.charAt(i) == this.clave.charAt(x)) {
                                this.respuesta = String.valueOf(this.respuesta) + "_ ";
                            }
                        }
                    }
                }
            }
        }
        return this.respuesta;
    }
}
