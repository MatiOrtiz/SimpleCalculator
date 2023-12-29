import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazGrafica extends JFrame
{
    private Calculadora calc;//atributo de la lógica
    
    //paneles
    private JPanel panelTeclas; // panel para colocar la matriz de botones que representan cada tecla de la calculadora
    private JPanel panelVisor; //  panel donde irá el visor de la calculadora
    
    //botones
    private JButton [][] teclas; //matriz que modela las teclas de la calculadora
   
    //etiquetas
    private JLabel etiquetaVisor; // etiqueta para visualizar la operación y el resultado
 
    //Constructor
    public InterfazGrafica()
    {
        super("Calculadora de operaciones simples");
        calc = new Calculadora();     //se crea una instancia de la lógica   
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("calculator.png")).getImage());
        iniciarInterfaz();
        setVisible(true);
    }
    
    
    private void iniciarInterfaz(){
         this.setLayout(new BorderLayout());
         
         //Creación del visor
         etiquetaVisor = new JLabel("",SwingConstants.CENTER);       
         etiquetaVisor.setFont(new Font("Calibri", Font.BOLD, 36));
         
         //Construcción del panel para el visor
         panelVisor = new JPanel();
         panelVisor.setPreferredSize(new Dimension(400,50));
         panelVisor.add(etiquetaVisor,BorderLayout.CENTER);
          
         //Construccion del panel para las teclas
         panelTeclas = new JPanel();
         panelTeclas.setLayout(new GridLayout(4,4));
         panelTeclas.setBorder(BorderFactory.createLineBorder(Color.black));
         
         //Construcción de cada uno de los botones de la matriz
         crearTeclas(); 
        
         //Añadidura de los paneles
         this.add(panelVisor,BorderLayout.NORTH);
         this.add(panelTeclas,BorderLayout.CENTER);
    }

    private void crearTeclas(){ 
        /**Implemente este metodo segun el adgoritmo que se encuentra en el enunciado*/
        
        teclas = new JButton[4][4];
        
        teclas[0][0] = new JButton("7");
        teclas[0][0].setActionCommand("7");
        OyenteDigito digito7= new OyenteDigito();
        teclas[0][0].addActionListener(digito7);
        
        teclas[0][1] = new JButton("8");
        teclas[0][1].setActionCommand("8"); 
        OyenteDigito digito8= new OyenteDigito();
        teclas[0][1].addActionListener(digito8);
        
        teclas[0][2] = new JButton("9");
        teclas[0][2].setActionCommand("9");
        OyenteDigito digito9= new OyenteDigito();
        teclas[0][2].addActionListener(digito9);
        
        teclas[0][3] = new JButton("/");
        teclas[0][3].setActionCommand("/");
        OyenteOperador div = new OyenteOperador();
        teclas[0][3].addActionListener(div);
        
        teclas[1][0] = new JButton("4");
        teclas[1][0].setActionCommand("4");
        OyenteDigito digito4= new OyenteDigito();
        teclas[1][0].addActionListener(digito4);
        
        teclas[1][1] = new JButton("5");
        teclas[1][1].setActionCommand("5");
        OyenteDigito digito5= new OyenteDigito();
        teclas[1][1].addActionListener(digito5);
        
        teclas[1][2] = new JButton("6");
        teclas[1][2].setActionCommand("6");
        OyenteDigito digito6= new OyenteDigito();
        teclas[1][2].addActionListener(digito6);
        
        teclas[1][3] = new JButton("x");
        teclas[1][3].setActionCommand("x");
        OyenteOperador por = new OyenteOperador();
        teclas[1][3].addActionListener(por);
        
        
        teclas[2][0] = new JButton("1");
        teclas[2][0].setActionCommand("1");
        OyenteDigito digito1= new OyenteDigito();
        teclas[2][0].addActionListener(digito1);
        
        teclas[2][1] = new JButton("2");
        teclas[2][1].setActionCommand("2");
        OyenteDigito digito2= new OyenteDigito();
        teclas[2][1].addActionListener(digito2);
        
        teclas[2][2] = new JButton("3");
        teclas[2][2].setActionCommand("3");
        OyenteDigito digito3= new OyenteDigito();
        teclas[2][2].addActionListener(digito3);
        
        teclas[2][3] = new JButton("-");
        teclas[2][3].setActionCommand("-");
        OyenteOperador menos = new OyenteOperador();
        teclas[2][3].addActionListener(menos);
        
        teclas[3][0] = new JButton("0");
        teclas[3][0].setActionCommand("0");
        OyenteDigito digito0= new OyenteDigito();
        teclas[3][0].addActionListener(digito0);
        
        teclas[3][1] = new JButton("=");
        teclas[3][1].setActionCommand("=");
        OyenteIgual igual = new OyenteIgual();
        teclas[3][1].addActionListener(igual);
        
        teclas[3][2] = new JButton("<");
        teclas[3][2].setActionCommand("<");
        OyenteBorrar borrar = new OyenteBorrar();
        teclas[3][2].addActionListener(borrar);
        
        teclas[3][3] = new JButton("+");
        teclas[3][3].setActionCommand("+");
        OyenteOperador mas = new OyenteOperador();
        teclas[3][3].addActionListener(mas);
        
        for(int f=0; f<4; f++)
            for(int c=0; c<4; c++){
                panelTeclas.add(teclas[f][c]);
                teclas[f][c].setFont(new Font("Calibri", Font.BOLD, 36));
            }
        
        //Desactivo los operadores
        teclas[0][3].setEnabled(false);
        teclas[1][3].setEnabled(false);
        teclas[2][3].setEnabled(false);
        teclas[3][1].setEnabled(false);
        teclas[3][3].setEnabled(false);
    }
    
    private class OyenteIgual implements ActionListener{ 
        public void actionPerformed(ActionEvent e){
             /**Implemente este metodo segun el comportamiento deseado*/
             int num1, num2, resultado= 0;
             char op;
             String resultadoS=("");
            
            //Obtengo los numeros ingresados en el visor
             num1 = Character.getNumericValue(etiquetaVisor.getText().charAt(etiquetaVisor.getText().length()-3));
             op = etiquetaVisor.getText().charAt(etiquetaVisor.getText().length()-2);
             num2 = Character.getNumericValue(etiquetaVisor.getText().charAt(etiquetaVisor.getText().length()-1));
            
            //Utilizo los metodos calc para devolver las operaciones 
             if(op == '+'){
                 resultado = calc.suma(num1,num2);
                 }
             else if(op == '-')
                 resultado= calc.resta(num1, num2);
             else if(op == 'x')
                 resultado= calc.producto(num1, num2);
             else if(op == '/'){
                 if(num2 == 0){
                     JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "Error: Division por 0", "Error", JOptionPane.ERROR_MESSAGE);
                 }
                  else resultado= calc.cociente(num1, num2);
            }
            if(op!='/' || num2!=0){
                resultadoS= Integer.toString(resultado);
                //Activo los operadores y desactivo el igual nuevamente
                teclas[0][3].setEnabled(true);
                teclas[1][3].setEnabled(true);
                teclas[2][3].setEnabled(true);
                teclas[3][1].setEnabled(false);
                teclas[3][3].setEnabled(true);
            }
            else{
                //Desactivo los operadores
                teclas[0][3].setEnabled(false);
                teclas[1][3].setEnabled(false);
                teclas[2][3].setEnabled(false);
                teclas[3][1].setEnabled(false);
                teclas[3][3].setEnabled(false);    
            }
            etiquetaVisor.setText(resultadoS);
            
            }
        }
    
    
    private class OyenteBorrar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            char ultima = ' ';
            if (etiquetaVisor.getText().length() != 0) //Si el visor no está vacío
            {
                //Se extrae último ingreso en el visor
                ultima = etiquetaVisor.getText().charAt(etiquetaVisor.getText().length()-1); 
                //Se "borra" del visor la última tecla ingresada, se número u operación
                etiquetaVisor.setText(etiquetaVisor.getText().substring(0,etiquetaVisor.getText().length() - 1));
                if (ultima == '+' || ultima == 'x' || ultima == '-' || ultima == '/') //Si lo último ingresado era un operador
                {
                    //Habilitar nuevamente las teclas de operaciones
                    teclas[0][3].setEnabled(true);
                    teclas[1][3].setEnabled(true);
                    teclas[2][3].setEnabled(true);
                    teclas[3][3].setEnabled(true);
                }
                //Si luego de borrar, el visor quedó vacío
                if (etiquetaVisor.getText().length() == 0) 
                {
                    //Deshabilitar teclas de operaciones para evitar una operación inválida
                    teclas[0][3].setEnabled(false);
                    teclas[1][3].setEnabled(false);
                    teclas[2][3].setEnabled(false);
                    teclas[3][3].setEnabled(false);
                }
                else //Si el visor no quedó vacío
                {
                    //Se extrae último ingreso, luego de borrar
                    ultima = etiquetaVisor.getText().charAt(etiquetaVisor.getText().length()-1); 
                    //Si lo último, luego de borrar, es un operador
                    if (ultima == '+' || ultima == 'x' || ultima == '-' || ultima == '/')
                        teclas[3][1].setEnabled(false); //Deshabilitar la tecla =
                }
            }
        }
    }
    
    private class OyenteOperador implements ActionListener{
        public void actionPerformed(ActionEvent e){
            etiquetaVisor.setText(etiquetaVisor.getText()+e.getActionCommand());
            //Deshabilitar teclas de operaciones, mientras no se borre el que ya fue ingresado
            teclas[0][3].setEnabled(false);
            teclas[1][3].setEnabled(false);
            teclas[2][3].setEnabled(false);
            teclas[3][3].setEnabled(false);
        }
    }
        
    private class OyenteDigito implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (etiquetaVisor.getText().length() != 0)// Si el visor no esta vacío
            {
                char ultima = etiquetaVisor.getText().charAt(etiquetaVisor.getText().length()-1);
                // Si ya fue seleccionado el operador
                if (ultima == '+' || ultima == 'x' || ultima == '-' || ultima == '/')
                    teclas[3][1].setEnabled(true);//Habilitar tecla "="
            }
            else // Si estaba vacío el visor
            {
                // Habilitar teclas de operaciones
                teclas[0][3].setEnabled(true);
                teclas[1][3].setEnabled(true);
                teclas[2][3].setEnabled(true);
                teclas[3][3].setEnabled(true);
            }
            // Se escribe el dígito tipeado en el visor
            etiquetaVisor.setText(etiquetaVisor.getText()+e.getActionCommand());
        }    
    }
}