                                                                                                                                                                                                                                                   
                                                                                                                                       
import java.awt.BasicStroke;                                                                                                           
import java.awt.BorderLayout;                                                                                                          
import java.awt.Color;                                                                                                                 
import static java.awt.Color.WHITE;                                                                                                    
import java.awt.Dimension;                                                                                                             
import java.awt.GradientPaint;                                                                                                         
import java.awt.Graphics;                                                                                                              
import java.awt.Graphics2D;                                                                                                            
import java.awt.Paint;                                                                                                                 
import java.awt.Stroke;                                                                                                                
import java.awt.event.ActionEvent;                                                                                                     
import java.awt.event.ActionListener;                                                                                                  
import java.awt.event.ItemEvent;                                                                                                       
import java.awt.event.ItemListener;                                                                                                    
import java.awt.event.MouseEvent;                                                                                                      
import java.awt.event.MouseMotionAdapter;                                                                                              
import java.awt.event.MouseMotionListener;                                                                                             
import static java.lang.Math.min;                                                                                                      
import java.util.ArrayList;                                                                                                            
import javax.swing.JButton;                                                                                                            
import javax.swing.JCheckBox;                                                                                                          
import javax.swing.JColorChooser;                                                                                                      
import javax.swing.JComboBox;                                                                                                          
import javax.swing.JFrame;                                                                                                             
import javax.swing.JLabel;                                                                                                             
import javax.swing.JPanel;                                                                                                             
import javax.swing.JTextField;                                                                                                         
                                                                                                                                       
public class Drawing {                                                                                                                 
                                                                                                                                       
                                                                                                                                       
public static abstract class shapes  {                                                                                                 
    private int x1;                                                                                                                    
    private int x2;                                                                                                                    
    private int y1;                                                                                                                    
    private int y2;                                                                                                                    
    Paint paint; //color                                                                                                               
    Stroke stroke; //width                                                                                                             
    public abstract void draw(Graphics2D g);                                                                                                                                                                                         
                                                                                                                                       
                                                                                                                                       
  public shapes(int x1,int x2, int y1, int y2,Paint paint,Stroke stroke){                                                              
      this.x1 = x1;                                                                                                                    
      this.x2 = x2;                                                                                                                    
      this.y1 = y1;                                                                                                                    
      this.y2 = y2;                                                                                                                    
      this.paint = paint;                                                                                                              
      this.stroke = stroke;                                                                                                            
                                                                                                                                       
                                                                                                                                       
  }                                                                                                                                    
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
    public int getX1() {                                                                                                               
        return x1;                                                                                                                     
    }                                                                                                                                  
                                                                                                                                       
    public int getX2() {                                                                                                               
        return x2;                                                                                                                     
    }                                                                                                                                  
                                                                                                                                       
    public int getY1() {                                                                                                               
        return y1;                                                                                                                     
    }                                                                                                                                  
                                                                                                                                       
    public int getY2() {                                                                                                               
        return y2;                                                                                                                     
    }                                                                                                                                  
                                                                                                                                       
    public Stroke getStroke() {                                                                                                        
        return stroke;                                                                                                                 
    }                                                                                                                                  
}                                                                                                                                      
    public static class rects extends bounded{                                                                                         
                                                                                                                                       
    public rects(int x1,int x2, int y1, int y2,Paint paint, Stroke stroke, boolean isfill){                                            
        super(x1, x2, y1, y2, paint,stroke, isfill);                                                                                   
                                                                                                                                       
                                                                                                                                       
    }                                                                                                                                  
                                                                                                                                       
    @Override                                                                                                                          
    public void draw(Graphics2D g2d){                                                                                                  
        g2d.setStroke(stroke);                                                                                                         
        g2d.setPaint(paint);                                                                                                           
        if (isfill == false)                                                                                                           
        g2d.drawRect(min(getX1(), getX2()), min(getY1(), getY2()), Math.abs(getX1()-getX2()), Math.abs(getY1()-getY2()));              
        else                                                                                                                           
        g2d.fillRect(min(getX1(), getX2()), min(getY1(), getY2()), Math.abs(getX1()-getX2()), Math.abs(getY1()-getY2()));              
                                                                                                                                       
    }                                                                                                                                  
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
}                                                                                                                                      
                                                                                                                                       
    public static class ovals extends bounded{                                                                                         
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
    public ovals(int x1,int x2, int y1, int y2, Paint paint, Stroke stroke,boolean isfill){                                            
        super(x1, x2, y1, y2, paint, stroke, isfill);                                                                                  
    }                                                                                                                                  
                                                                                                                                       
                                                                                                                                       
    @Override                                                                                                                          
    public void draw(Graphics2D g2d){                                                                                                  
        g2d.setStroke(stroke);                                                                                                         
        g2d.setPaint(paint);                                                                                                           
        if (isfill == false)                                                                                                           
        g2d.drawOval(min(getX1(), getX2()), min(getY1(), getY2()), Math.abs(getX1()-getX2()), Math.abs(getY1()-getY2()));              
        else                                                                                                                           
        g2d.fillOval(min(getX1(), getX2()), min(getY1(), getY2()), Math.abs(getX1()-getX2()), Math.abs(getY1()-getY2()));              
    }                                                                                                                                  
                                                                                                                                       
                                                                                                                                       
}                                                                                                                                      
                                                                                                                                       
    public static class lines extends shapes{                                                                                          
                                                                                                                                       
                                                                                                                                       
    public lines(int x1,int x2, int y1, int y2,Paint paint, Stroke stroke){                                                            
    super(x1,x2, y1, y2, paint, stroke);                                                                                               
                                                                                                                                       
                                                                                                                                       
    }                                                                                                                                  
                                                                                                                                       
    @Override                                                                                                                          
    public void draw(Graphics2D g2d){                                                                                                  
        g2d.setStroke(stroke);                                                                                                         
        g2d.setPaint(paint);                                                                                                           
        g2d.drawLine(getX1(), getY1(), getX2(), getY2());                                                                              
                                                                                                                                       
                                                                                                                                       
    }                                                                                                                                  
    }                                                                                                                                  
    public static class drawPanel extends JPanel {                                                                                     
                                                                                                                                       
    private int x1 = -1;                                                                                                               
    private int x2;                                                                                                                    
    private int y1;                                                                                                                    
    private int y2;                                                                                                                    
    private ArrayList<shapes> shapArray = new ArrayList<>();                                                                           
    private frame f;                                                                                                                   
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
    private Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,                                        
            new float[]{3, 0}, 0);                                                                                                     
    private Paint paint = new GradientPaint(5, 30, Color.BLACK, 35, 100, Color.BLACK, true);                                           
                                                                                                                                       
    public drawPanel(frame f) {                                                                                                        
        this.f = f;                                                                                                                    
                                                                                                                                       
        addMouseMotionListener(mouseMotionHandler);                                                                                    
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
    }                                                                                                                                  
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
    public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {                                                         
        @Override                                                                                                                      
        public void mouseDragged(MouseEvent e) {                                                                                       
            if (x1 == -1) {                                                                                                            
                x1 = e.getX();                                                                                                         
                y1 = e.getY();                                                                                                         
                x2 = e.getX();                                                                                                         
                y2 = e.getY();                                                                                                         
                                                                                                                                       
                if (f.isIsdash() == false) {                                                                                           
                    stroke = new BasicStroke(f.getW(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,                                
                            new float[]{3, 0}, 0);                                                                                     
                } else {                                                                                                               
                    stroke = new BasicStroke(f.getW(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,                                
                            new float[]{10, f.getL()}, 0);                                                                             
                }                                                                                                                      
                                                                                                                                       
                if (f.isIsgradient() == false) {                                                                                       
                    paint = new GradientPaint(5, 30, f.getColor1(), 35, 100, f.getColor1(), true);                                     
                } else {                                                                                                               
                    paint = new GradientPaint(5, 30, f.getColor1(), 35, 100, f.getColor2(), true);                                     
                }                                                                                                                      
                                                                                                                                       
                if (f.getBoxSelected() == 0) {                                                                                         
                    shapArray.add(new lines(x1, x2, y1, y2, paint, stroke));                                                           
                } else if (f.getBoxSelected() == 1) {                                                                                  
                    shapArray.add(new ovals(x1, x2, y1, y2, paint, stroke, f.isIsfill()));                                             
                } else {                                                                                                               
                    shapArray.add(new rects(x1, x2, y1, y2, paint, stroke, f.isIsfill()));                                             
                }                                                                                                                      
                                                                                                                                       
                                                                                                                                       
                repaint();                                                                                                             
                                                                                                                                       
            } else {                                                                                                                   
                x2 = e.getX();                                                                                                         
                y2 = e.getY();                                                                                                         
                                                                                                                                       
                if (f.isIsdash() == false) {                                                                                           
                    stroke = new BasicStroke(f.getW(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,                                
                            new float[]{3, 0}, 0);                                                                                     
                } else {                                                                                                               
                    stroke = new BasicStroke(f.getW(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,                                
                            new float[]{10, f.getL()}, 0);                                                                             
                }                                                                                                                      
                                                                                                                                       
                if (f.isIsgradient() == false) {                                                                                       
                    paint = new GradientPaint(5, 30, f.getColor1(), 35, 100, f.getColor1(), true);                                     
                } else {                                                                                                               
                    paint = new GradientPaint(5, 30, f.getColor1(), 35, 100, f.getColor2(), true);                                     
                }                                                                                                                      
                                                                                                                                       
                                                                                                                                       
                if (f.getBoxSelected() == 0) {                                                                                         
                    shapArray.set(shapArray.size() - 1, new lines(x1, x2, y1, y2, paint, stroke));                                     
                } else if (f.getBoxSelected() == 1) {                                                                                  
                    shapArray.set(shapArray.size() - 1, new ovals(x1, x2, y1, y2, paint, stroke, f.isIsfill()));                       
                } else {                                                                                                               
                    shapArray.set(shapArray.size() - 1, new rects(x1, x2, y1, y2, paint, stroke, f.isIsfill()));                       
                }                                                                                                                      
                repaint();                                                                                                             
            }                                                                                                                          
                                                                                                                                       
        }                                                                                                                              
                                                                                                                                       
        public void mouseMoved(MouseEvent e) {                                                                                         
            x1 = -1;                                                                                                                   
            repaint();                                                                                                                 
        }                                                                                                                              
                                                                                                                                       
        //shap.remove(shap.size()-2);                                                                                                  
    };                                                                                                                                 
                                                                                                                                       
    public void undoFun() {                                                                                                            
                                                                                                                                       
        if (shapArray.size() != 0) {                                                                                                   
            shapArray.remove(shapArray.size() - 1);                                                                                    
        }                                                                                                                              
        repaint();                                                                                                                     
    }                                                                                                                                  
                                                                                                                                       
    public void clearFun() {                                                                                                           
        if (shapArray.size() != 0) {                                                                                                   
            shapArray.removeAll(shapArray);                                                                                            
        }                                                                                                                              
        repaint();                                                                                                                     
    }                                                                                                                                  
                                                                                                                                       
    @Override                                                                                                                          
    public void paintComponent(Graphics g) {                                                                                           
        Graphics2D g2d = (Graphics2D) g;                                                                                               
        super.paintComponent(g2d);                                                                                                     
                                                                                                                                       
        for (shapes s : shapArray) {                                                                                                   
                                                                                                                                       
            s.draw(g2d);                                                                                                               
                                                                                                                                       
        }                                                                                                                              
                                                                                                                                       
    }                                                                                                                                  
}                                                                                                                                      
                                                                                                                                       
    public static abstract class bounded extends shapes{                                                                               
    boolean isfill;                                                                                                                    
    public abstract void draw(Graphics2D g2d);                                                                                         
                                                                                                                                       
                                                                                                                                       
    public bounded(int x1,int x2, int y1, int y2,Paint paint, Stroke stroke, boolean isfill){                                          
       super(x1, x2, y1, y2, paint, stroke);                                                                                           
                                                                                                                                       
       this.isfill = isfill;                                                                                                           
                                                                                                                                       
    }                                                                                                                                  
                                                                                                                                       
                                                                                                                                       
}                                                                                                                                      
                                                                                                                                       
                                                                                                                                       
   public static class frame extends JFrame {                                                                                          
                                                                                                                                       
    private final JButton color1Button;                                                                                                
    private final JButton color2Button;                                                                                                
                                                                                                                                       
    private final JButton undoButton;                                                                                                  
    private final JButton clearButton;                                                                                                 
    private final BorderLayout layout;                                                                                                 
                                                                                                                                       
    private JPanel panel1;                                                                                                             
    private JPanel panel2;                                                                                                             
    private JPanel panel3;                                                                                                             
    private JPanel panel4;                                                                                                             
    private JPanel panelA;                                                                                                             
    private final JComboBox<String> shapesBox;                                                                                         
    private final String[] shapeNames = {"Line", "Oval", "Rectangle"};                                                                 
                                                                                                                                       
    private final JCheckBox gradientBox;                                                                                               
    private final JCheckBox filledBox;                                                                                                 
    private final JCheckBox dashedBox;                                                                                                 
    private final JTextField widthText;                                                                                                
    private final JTextField lengthText;                                                                                               
    private final JLabel widLabel;                                                                                                     
    private final JLabel lenLabel;                                                                                                     
                                                                                                                                       
    private JLabel statusLabel;                                                                                                        
                                                                                                                                       
    private int boxSelected = 0;                                                                                                       
    private boolean isdash = false;                                                                                                    
    private boolean isgradient = false;                                                                                                
    private boolean isfill = false;                                                                                                    
    private int w = 10;                                                                                                                
    private int l = 15;                                                                                                                
    private Color color1 = Color.BLACK;                                                                                                
    private Color color2 = Color.BLUE;                                                                                                 
                                                                                                                                       
    public frame() {                                                                                                                   
        super("Java 2D Drawings");                                                                                                     
                                                                                                                                       
                                                                                                                                       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                                
        setSize(800, 800);                                                                                                             
                                                                                                                                       
        layout = (new BorderLayout(5, 5));                                                                                             
        setLayout(layout);                                                                                                             
                                                                                                                                       
        JPanel panel1 = new JPanel();                                                                                                  
                                                                                                                                       
        JPanel panel2 = new JPanel();                                                                                                  
                                                                                                                                       
        drawPanel panel3 = new drawPanel(this);                                                                                        
        panel3.setBackground(WHITE);                                                                                                   
                                                                                                                                       
        JPanel panel4 = new JPanel();                                                                                                  
        JPanel panelA = new JPanel();                                                                                                  
                                                                                                                                       
        panel1.setPreferredSize(new Dimension(800, 30));                                                                               
        panel2.setPreferredSize(new Dimension(800, 30));                                                                               
        panel4.setPreferredSize(new Dimension(800, 30));                                                                               
        panel3.setPreferredSize(new Dimension(800, 650));                                                                              
        panelA.setPreferredSize(new Dimension(800, 80));                                                                               
                                                                                                                                       
        gradientBox = new JCheckBox("Use Gradient");                                                                                   
        panel2.add(gradientBox);                                                                                                       
                                                                                                                                       
        undoButton = new JButton("Undo");                                                                                              
        clearButton = new JButton("Clear");                                                                                            
        color1Button = new JButton("1st color");                                                                                       
        color2Button = new JButton("2nd color");                                                                                       
        panel1.add(undoButton);                                                                                                        
        panel1.add(clearButton);                                                                                                       
        panel2.add(color1Button);                                                                                                      
        panel2.add(color2Button);                                                                                                      
                                                                                                                                       
        widLabel = new JLabel("Width");                                                                                                
        lenLabel = new JLabel("length");                                                                                               
        widthText = new JTextField(Integer.toString(w),2);                                                                             
        lengthText = new JTextField(Integer.toString(l),2);                                                                            
        panel2.add(widLabel);                                                                                                          
        panel2.add(widthText);                                                                                                         
        panel2.add(lenLabel);                                                                                                          
        panel2.add(lengthText);                                                                                                        
                                                                                                                                       
        shapesBox = new JComboBox<>(shapeNames);                                                                                       
        shapesBox.setMaximumRowCount(3);                                                                                               
        panel1.add(shapesBox);                                                                                                         
                                                                                                                                       
        filledBox = new JCheckBox("Filled");                                                                                           
        panel1.add(filledBox);                                                                                                         
                                                                                                                                       
        dashedBox = new JCheckBox("Dashed");                                                                                           
        panel2.add(dashedBox);                                                                                                         
                                                                                                                                       
        color1Button.addActionListener(new ActionListener() {                                                                          
            public void actionPerformed(ActionEvent e) {                                                                               
                //repaint();                                                                                                           
                color1 = JColorChooser.showDialog(null, "Choose a color", color1);                                                     
                                                                                                                                       
                if (color1 == null) {                                                                                                  
                    color1 = Color.BLACK;                                                                                              
                }                                                                                                                      
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        color2Button.addActionListener(new ActionListener() {                                                                          
            public void actionPerformed(ActionEvent e) {                                                                               
                                                                                                                                       
                color2 = JColorChooser.showDialog(null, "Choose a color", color2);                                                     
                                                                                                                                       
                if (color2 == null) {                                                                                                  
                    color2 = Color.BLACK;                                                                                              
                }                                                                                                                      
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        undoButton.addActionListener(new ActionListener() {                                                                            
            public void actionPerformed(ActionEvent e) {                                                                               
                panel3.undoFun();                                                                                                      
                                                                                                                                       
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        clearButton.addActionListener(new ActionListener() {                                                                           
            public void actionPerformed(ActionEvent e) {                                                                               
                panel3.clearFun();                                                                                                     
                                                                                                                                       
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        shapesBox.addItemListener(new ItemListener() {                                                                                 
            @Override                                                                                                                  
            public void itemStateChanged(ItemEvent event) {                                                                            
                if (event.getStateChange() == ItemEvent.SELECTED) {                                                                    
                    boxSelected = shapesBox.getSelectedIndex();                                                                        
                }                                                                                                                      
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
                                                                                                                                       
        dashedBox.addItemListener(new ItemListener() {                                                                                 
            public void itemStateChanged(ItemEvent event) {                                                                            
                if (dashedBox.isSelected()) {                                                                                          
                    isdash = true;                                                                                                     
                } else if (!dashedBox.isSelected()) {                                                                                  
                    isdash = false;                                                                                                    
                }                                                                                                                      
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        gradientBox.addItemListener(new ItemListener() {                                                                               
            public void itemStateChanged(ItemEvent event) {                                                                            
                if (gradientBox.isSelected()) {                                                                                        
                    isgradient = true;                                                                                                 
                } else if (!gradientBox.isSelected()) {                                                                                
                    isgradient = false;                                                                                                
                }                                                                                                                      
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        filledBox.addItemListener(new ItemListener() {                                                                                 
            public void itemStateChanged(ItemEvent event) {                                                                            
                if (filledBox.isSelected()) {                                                                                          
                    isfill = true;                                                                                                     
                } else if (!filledBox.isSelected()) {                                                                                  
                    isfill = false;                                                                                                    
                }                                                                                                                      
                                                                                                                                       
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        widthText.addActionListener(new ActionListener() {                                                                             
            public void actionPerformed(ActionEvent e) {                                                                               
                w = Integer.parseInt(widthText.getText());                                                                             
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        lengthText.addActionListener(new ActionListener() {                                                                            
            public void actionPerformed(ActionEvent e) {                                                                               
                l = Integer.parseInt(lengthText.getText());                                                                            
            }                                                                                                                          
        });                                                                                                                            
                                                                                                                                       
        statusLabel = new JLabel("(0,0)");                                                                                             
                                                                                                                                       
        panel3.addMouseMotionListener(new MouseMotionListener() {                                                                      
            public void mouseMoved(MouseEvent event) {                                                                                 
                statusLabel.setText(String.format("(%d,%d)", event.getX(), event.getY()));                                             
            }                                                                                                                          
                                                                                                                                       
            @Override                                                                                                                  
            public void mouseDragged(MouseEvent event) {                                                                               
                statusLabel.setText(String.format("(%d,%d)", event.getX(), event.getY()));                                             
            }                                                                                                                          
        });                                                                                                                            
        panel4.add(statusLabel);                                                                                                       
                                                                                                                                       
                                                                                                                                       
//                                                                                                                                     
        panelA.add(panel1, BorderLayout.NORTH);                                                                                        
        panelA.add(panel2, BorderLayout.SOUTH);                                                                                        
                                                                                                                                       
        add(panelA, BorderLayout.NORTH);                                                                                               
        add(panel3, BorderLayout.CENTER);                                                                                              
        add(panel4, BorderLayout.SOUTH);                                                                                               
                                                                                                                                       
        setVisible(true);                                                                                                              
                                                                                                                                       
    }                                                                                                                                  
                                                                                                                                       
                                                                                                                                       
                                                                                                                                       
    public int getBoxSelected() {                                                                                                      
        return boxSelected;                                                                                                            
    }                                                                                                                                  
                                                                                                                                       
    public boolean isIsdash() {                                                                                                        
        return isdash;                                                                                                                 
    }                                                                                                                                  
                                                                                                                                       
    public boolean isIsgradient() {                                                                                                    
        return isgradient;                                                                                                             
    }                                                                                                                                  
                                                                                                                                       
    public boolean isIsfill() {                                                                                                        
        return isfill;                                                                                                                 
    }                                                                                                                                  
                                                                                                                                       
    public int getW() {                                                                                                                
        return w;                                                                                                                      
    }                                                                                                                                  
                                                                                                                                       
    public int getL() {                                                                                                                
        return l;                                                                                                                      
    }                                                                                                                                  
                                                                                                                                       
    public Color getColor1() {                                                                                                         
        return color1;                                                                                                                 
    }                                                                                                                                  
                                                                                                                                       
    public Color getColor2() {                                                                                                         
        return color2;                                                                                                                 
    }                                                                                                                                  
}                                                                                                                                      
                                                                                                                                       
                                                                                                                                       
    public static void main(String[] args) {                                                                                           
        new frame();                                                                                                                   
    }                                                                                                                                  
                                                                                                                                       
}                                                                                                                                      
                                                                                                                                       