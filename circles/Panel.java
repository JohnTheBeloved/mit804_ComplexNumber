
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johnthebeloved
 */
public class Panel extends JDialog {

    private JLabel canvasIcon;
    private JButton jButtonCancel;
    private JButton jButtonOK;
    private JLabel jLabelEnterNo;
    private JLabel jLabelEnterRange;
    private JTextField noOfCirclesTextFeild;
    private JTextField rangeOfSizesTextField;
    private int noOfCircles;
    private int lowerRange;
    private int higherRange;
    
    
    
	public Panel(JFrame owner,boolean modal){
		
        super(owner,modal);
		jButtonOK = new JButton();
        jButtonCancel = new JButton();
        canvasIcon = new JLabel();
      
		noOfCirclesTextFeild = new JTextField();
        rangeOfSizesTextField = new JTextField();
        jLabelEnterNo = new JLabel("Enter number of circles");
        jLabelEnterRange = new JLabel("Enter the range of sizes");
        
        Icon icon = UIManager.getIcon("OptionPane.questionIcon");
        
        canvasIcon.setIcon(icon);
        
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButtonOK.setText("OK");
        
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
                    try{
                        if(Integer.parseInt(noOfCirclesTextFeild.getText()) < 0)throw new Exception("Enter Number of Circles more than 1");
                        if(!rangeOfSizesTextField.getText().contains("-"))throw new Exception("Not Range Format entered");
                        
                        noOfCircles = Integer.parseInt(noOfCirclesTextFeild.getText());
                        String ranges = rangeOfSizesTextField.getText();
                        StringTokenizer tokenizer = new StringTokenizer(ranges);
                        lowerRange = Integer.parseInt(tokenizer.nextToken("-"));
                        if(         getLowerRange() < 1)throw new Exception("Lower size less than 1");
                        
                        higherRange =Integer.parseInt(tokenizer.nextToken("").replace("-", ""));
                        if(getHigherRange() < 1)throw new Exception("Higher size less than 1");
                        if(getHigherRange() < getLowerRange())throw new Exception("Higher size less than Lower Range");
                        
                        System.out.println("No of Circles"+ getNoOfCircles() + "Lower Range"+getLowerRange() + "Higher"+getHigherRange());
                        setVisible(false);
                    }catch(NumberFormatException nexp){
                        JOptionPane.showMessageDialog(rootPane,"Please enter correct numer :\n"+ nexp.getMessage());
                        
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(rootPane,"Invalid value :\n"+ ex.getMessage());
                    }
                         
                    
                
                }
            
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  System.exit(1);
            }
        });
        
        setLayouts();
            setVisible(true);
	}
        
        
        
        private void setLayouts(){
            setSize(350, 200);
            setResizable(false);
            setLocationRelativeTo(null);
            getRootPane().setDefaultButton(jButtonOK);
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(canvasIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(noOfCirclesTextFeild)
                        .addComponent(rangeOfSizesTextField))
                    .addComponent(jLabelEnterNo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEnterRange, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEnterNo)
                        .addGap(8, 8, 8)
                        .addComponent(noOfCirclesTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEnterRange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rangeOfSizesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canvasIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        }
        
   

    public int getNoOfCircles() {
        return noOfCircles;
    }

    public int getLowerRange() {
        return lowerRange;
    }

    public int getHigherRange() {
        return higherRange;
    }
}