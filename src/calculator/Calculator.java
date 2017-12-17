package calculator;

import java.awt.*;
import java.awt.event.*;


public class Calculator {

    // for original mode
    private static Frame frm = new Frame("Simple Mode");
    private static Panel pn1 = new Panel(new GridLayout(5, 3));
    private static Panel pn2 = new Panel(new GridLayout(5, 1));
    private static Label lab = new Label("0", Label.RIGHT);
    // clear, add, sub, mul, div, equ, module
    private static Button clean, add, sub, mul, div, equ, mod, scimod, point;
    private static boolean continueenterdigit = false;
    // number 0 to 9
    private static Button digits[] = new Button[10];
    private static long num;    // store the results
    private static byte op = 0;     // operator

    // for scientific mode
    private static Frame frm_SM = new Frame("Scientific Mode");
    private static Panel pn1_SM = new Panel(new GridLayout(5, 3));
    private static Panel pn2_SM = new Panel(new GridLayout(5, 1));
    private static Panel pn3_SM = new Panel(new GridLayout(5, 1));
    private static Label lab_SM = new Label("0", Label.RIGHT);
    private static Label lab_triangle_SM = new Label("", Label.CENTER);
    // clear, add, sub, mul, div, equ, module
    private static Button clean_SM, add_SM, sub_SM, mul_SM, div_SM, equ_SM, mod_SM, orimod_SM, sin_SM, cos_SM, tan_SM, fac_SM, par_SM;
    private static boolean continueenterdigit_SM = false;    
    // number 0 to 9
    private static Button digits_SM[] = new Button[11]; // indlude point
    private static Double num_SM = 0.0;    // store the results
    private static String num_string_SM = "0";
    private static byte op_SM = 0;     // operator
    private static boolean isfloat_SM = false;
    //private static String display_SM = "0";

    public static void main(String args[]) {
        
        // Original Mode
        frm.setLayout(null);
        frm.setBounds(450, 250, 320, 360);
        frm.setResizable(false);
        lab.setBounds(30, 60, 250, 40);
        lab.setBackground(new Color(255, 230, 255));
        pn1.setBounds(30, 115, 180, 210);
        pn2.setBounds(220, 157, 60, 210); // last column with functional buttons

        // inside pn1
        scimod = new Button("MODE");
        pn1.add(scimod);
        scimod.addActionListener(new ActChangeSciMode());
        clean = new Button("C");
        pn1.add(clean);
        clean.addActionListener(new ActLis());
        mod = new Button("%");
        pn1.add(mod);
        mod.addActionListener(new ActLis());

        // number 0 - 9
        for (int i = 9; i > 0; i--) {
            digits[i] = new Button(Integer.toString(i));
            pn1.add(digits[i]);
            digits[i].addActionListener(new ActLis());
        }
        equ = new Button("Enter");
        pn1.add(equ);
        equ.addActionListener(new ActLis());
        int i = 0;
        digits[i] = new Button(Integer.toString(i));
        pn1.add(digits[i]);
        digits[i].addActionListener(new ActLis());


        // inside pn2
        add = new Button("+");
        pn2.add(add);
        add.addActionListener(new ActLis());
        sub = new Button("-");
        pn2.add(sub);
        sub.addActionListener(new ActLis());
        mul = new Button("*");
        pn2.add(mul);
        mul.addActionListener(new ActLis());
        div = new Button("/");
        pn2.add(div);
        div.addActionListener(new ActLis());

        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void
                    windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frm.add(lab);
        frm.add(pn1);
        frm.add(pn2);
        frm.setVisible(true);

        
        // Scientific Mode
        frm_SM.setLayout(null);
        frm_SM.setBounds(770, 250, 390, 360);
        frm_SM.setResizable(false);
        //frm_SM.setBackground(new Color(255, 204, 229));

        lab_triangle_SM.setBounds(30, 60, 60, 40);
        lab_triangle_SM.setBackground(new Color(255, 255, 240));        
        
        lab_SM.setBounds(90, 60, 260, 40);
        lab_SM.setBackground(new Color(255, 234, 240));
        
        pn1_SM.setBounds(30, 115, 180, 210);
        pn2_SM.setBounds(220, 157, 60, 210);// last column with functional buttons        
        pn3_SM.setBounds(290, 157, 60, 210);// last column with functional buttons 
        frm_SM.addWindowListener(new WindowAdapter() {
            @Override
            public void
                    windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // inside pn1_SM
        orimod_SM = new Button("MODE");
        pn1_SM.add(orimod_SM);
        orimod_SM.addActionListener(new ActChangetoOriMode());
        
        clean_SM = new Button("C");
        pn1_SM.add(clean_SM);
        clean_SM.addActionListener(new ActLis_SM());
        mod_SM = new Button("%");
        pn1_SM.add(mod_SM);
        mod_SM.addActionListener(new ActLis_SM());
        // number 0 - 9
        for (int j = 9; j > 0; j--) {
            digits_SM[j] = new Button(Integer.toString(j));
            pn1_SM.add(digits_SM[j]);
            digits_SM[j].addActionListener(new ActLis_SM());
        }
        
        equ_SM = new Button("Enter");
        pn1_SM.add(equ_SM);
        equ_SM.addActionListener(new ActLis_SM());        
        int j = 0;
        digits_SM[j] = new Button(Integer.toString(j));
        pn1_SM.add(digits_SM[j]);
        digits_SM[j].addActionListener(new ActLis_SM());        
        digits_SM[10] = new Button(".");
        pn1_SM.add(digits_SM[10]);
        digits_SM[10].addActionListener(new ActLis_SM());



        // inside pn2_SM
        add_SM = new Button("+");
        pn2_SM.add(add_SM);
        add_SM.addActionListener(new ActLis_SM());
        sub_SM = new Button("-");
        pn2_SM.add(sub_SM);
        sub_SM.addActionListener(new ActLis_SM());
        mul_SM = new Button("*");
        pn2_SM.add(mul_SM);
        mul_SM.addActionListener(new ActLis_SM());
        div_SM = new Button("/");
        pn2_SM.add(div_SM);
        div_SM.addActionListener(new ActLis_SM());

        // inside pn3_SM
        sin_SM = new Button("sin");
        pn3_SM.add(sin_SM);
        sin_SM.addActionListener(new ActLis_SM());
        cos_SM = new Button("cos");
        pn3_SM.add(cos_SM);
        cos_SM.addActionListener(new ActLis_SM());
        tan_SM = new Button("tan");
        pn3_SM.add(tan_SM);
        tan_SM.addActionListener(new ActLis_SM());
        fac_SM = new Button("n!");
        pn3_SM.add(fac_SM);
        fac_SM.addActionListener(new ActLis_SM());        
        
        
        
        frm_SM.add(lab_SM);
        frm_SM.add(lab_triangle_SM);
        frm_SM.add(pn1_SM);
        frm_SM.add(pn2_SM);
        frm_SM.add(pn3_SM);
        frm_SM.setVisible(false);

    }

    public static class ActLis implements ActionListener {

        public void actionPerformed(ActionEvent e) throws NumberFormatException, ArithmeticException {
            long result; // store the result

            Button btn = (Button) e.getSource();
            try {
                // for digit 0 to 9
                for (int i = 0; i <= 9; i++) {
                    if (btn == digits[i]) {
                        output_digit(digits[i]);
                        continueenterdigit = true;
                        break;
                    }
                }
                if (btn == clean) {
                    result = 0L;
                    num = 0L;
                    continueenterdigit = false;
                    op = 0;
                    lab.setText(Long.toString(num));
                } else if (btn == add) {
                    continueenterdigit = false;
                    save_num(add);
                    System.out.println("add");
                    lab.setText(Long.toString(num));
                    op = 1;
                } else if (btn == sub) {
                    continueenterdigit = false;
                    save_num(sub);
                    System.out.println("sub");
                    lab.setText(Long.toString(num));
                    op = 2;
                } else if (btn == mul) {
                    continueenterdigit = false;
                    save_num(mul);
                    System.out.println("mul");
                    lab.setText(Long.toString(num));
                    op = 3;
                } else if (btn == div) {
                    continueenterdigit = false;
                    save_num(div);
                    System.out.println("div");
                    lab.setText(Long.toString(num));
                    op = 4;
                } else if (btn == mod) {
                    continueenterdigit = false;
                    save_num(mod);
                    System.out.println("module");
                    lab.setText(Long.toString(num));
                    op = 5;
                } else if (btn == equ) {
                    continueenterdigit = false;
                    result = Long.parseLong(lab.getText());
                    System.out.println("equals");
                    switch (op) {
                        case 0:
                            num = result;
                            break;
                        case 1:
                            num += result;
                            op = 0;
                            break;
                        case 2:
                            num -= result;
                            op = 0;
                            break;
                        case 3:
                            num *= result;
                            op = 0;
                            break;
                        case 4:
                            num /= result;
                            op = 0;
                            break;
                        case 5:
                            num %= result;
                            op = 0;
                            break;
                        default:
                    }
                    result = 0L;
                    op = 0;
                    lab.setText(Long.toString(num));
                    num = 0L;
                }
            } catch (NumberFormatException ne) {
                lab.setText("Exception on number");
                System.out.println(ne);
            } catch (ArithmeticException ae) {
                lab.setText("Exception on arithmetic");
                System.out.println(ae);
            }
        }

        private void output_digit(Button btn) {
            if(continueenterdigit){
                lab.setText(Long.toString(Long.parseLong(lab.getText() + btn.getLabel())));
                System.out.println("not continueenterdigit");
            }
            else{
                lab.setText(Long.toString(Long.parseLong(btn.getLabel())));
                System.out.println("not continueenterdigit");
            }
            
            System.out.println("press on " + btn.getLabel());
        }

        private void save_num(Button oper) {
            num = Long.parseLong(lab.getText());
            lab.setText(Long.toString(0L));
        }
    }

    /**
     *
     */
    private static class ActChangetoOriMode implements ActionListener {

        public ActChangetoOriMode() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frm.setVisible(true);
            frm_SM.setVisible(false);
            num_SM = 0.0;
            op_SM = 0;
            lab_SM.setText("0");
        }
    }

    private static class ActChangeSciMode implements ActionListener {

        public ActChangeSciMode() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frm.setVisible(false);
            num = 0L;
            op = 0;
            lab.setText(Long.toString(num));
            frm_SM.setVisible(true);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    private static class ActLis_SM implements ActionListener {
/*
        public ActLis_SM() {
        }
*/    
        @Override
        public void actionPerformed(ActionEvent e) throws NumberFormatException, ArithmeticException {
            Double result; // store the result
            String result_string;
            Button btn = (Button) e.getSource();
            try {
                // for digit 0 to 9
                for (int i = 0; i <= 10; i++) {
                    if (btn == digits_SM[i]) {
                        if(i == 10 && isfloat_SM ){ //point
                            System.out.println("Error of multiple points");
                        }
                        else if(i == 10){
                            output_digit(digits_SM[i]);
                            continueenterdigit_SM = true;
                            isfloat_SM = true;
                        }
                        else{
                            output_digit(digits_SM[i]);
                            continueenterdigit_SM = true;                            
                        }
                        break;
                    }
                }
                if (btn == clean_SM) {
                    result = 0.0;
                    result_string = "0";
                    num_SM = 0.0;
                    num_string_SM = "0";
                    continueenterdigit_SM = false;
                    op_SM = 0;
                    isfloat_SM = false;
                    lab_SM.setText(num_string_SM);
                    lab_triangle_SM.setText("");
                } else if (btn == add_SM) {
                    continueenterdigit_SM = false;
                    save_num(add_SM);
                    lab_triangle_SM.setText("");
                    isfloat_SM = false;
                    System.out.println("add");
                    lab_SM.setText(String.valueOf(num_SM));
                    op_SM = 1;
                } else if (btn == sub_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    save_num(sub_SM);
                    lab_triangle_SM.setText("");
                    System.out.println("sub");
                    lab_SM.setText(String.valueOf(num_SM));
                    op_SM = 2;
                } else if (btn == mul_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    lab_triangle_SM.setText("");
                    save_num(mul_SM);
                    System.out.println("mul");
                    lab_SM.setText(String.valueOf(num_SM));
                    op_SM = 3;
                } else if (btn == div_SM) {
                    isfloat_SM = false;
                    continueenterdigit_SM = false;
                    lab_triangle_SM.setText("");
                    save_num(div_SM);
                    System.out.println("div");
                    lab_SM.setText(String.valueOf(num_SM));
                    op_SM = 4;
                } else if (btn == mod_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    lab_triangle_SM.setText("");
                    save_num(mod_SM);
                    System.out.println("module");
                    lab_SM.setText(String.valueOf(num_SM));
                    op_SM = 5;
                } else if (btn == sin_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    triangle_num(sin_SM);
                    System.out.println("sin");
                    lab_triangle_SM.setText("sin");
                    lab_SM.setText("0");
                    op_SM = 6;
                } else if (btn == cos_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    triangle_num(cos_SM);
                    System.out.println("cos");
                    lab_triangle_SM.setText("cos");
                    lab_SM.setText("0");
                    op_SM = 7;
                } else if (btn == tan_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    triangle_num(tan_SM);
                    System.out.println("tan");
                    lab_triangle_SM.setText("tan");
                    lab_SM.setText("0");
                    op_SM = 8;
                } else if (btn == fac_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    triangle_num(cos_SM);
                    System.out.println("fac");
                    lab_triangle_SM.setText("n =");
                    lab_SM.setText("0");
                    op_SM = 9;
                } else if (btn == equ_SM) {
                    continueenterdigit_SM = false;
                    isfloat_SM = false;
                    result = Double.parseDouble(lab_SM.getText());
                    System.out.println("num_SM : " + num_SM);
                    System.out.println("result : " + result);
                    System.out.println("equals");
                    lab_triangle_SM.setText("");
                    if(op_SM < 6){
                        switch (op_SM) {
                            case 0:
                                num_SM = result;
                                break;
                            case 1:
                                num_SM += result;
                                break;
                            case 2:
                                num_SM -= result;
                                break;
                            case 3:
                                num_SM *= result;
                                break;
                            case 4:
                                num_SM /= result;
                                break;
                            case 5:
                                num_SM %= result;
                                break;
                            default:
                        }
                        result = 0.0;
                        op_SM = 0;
                        System.out.println(" - num_SM : " + num_SM);
                        lab_SM.setText(Double.toString(round(num_SM, 7)));
                        //num_string_SM = String.valueOf(num_SM);
                        //lab_SM.setText(num_string_SM);
                        num_SM = 0.0;
                    }
                    else{
                        double radians = 0;
                        double num_SM_triangle = 1;
                        switch(op_SM){
                            case 6:
                                radians = Math.toRadians(result);
                                num_SM_triangle = Math.sin(radians);
                                break;
                            case 7:
                                radians = Math.toRadians(result);
                                num_SM_triangle = Math.cos(radians);
                                break;
                            case 8:
                                radians = Math.toRadians(result);
                                num_SM_triangle = Math.tan(radians);
                                break;
                            case 9:
                                for(int i=1;i<=result;i++){
                                    num_SM_triangle *= i;
                                }
                            default:
                        }
                        result = 0.0;
                        op_SM = 0;
                        lab_SM.setText(Double.toString(num_SM_triangle));
                        num_SM_triangle = 0L;
                        
                    }
                }
            } /*catch (NumberFormatException ne) {
                lab_SM.setText("Exception on number");
                System.out.println(ne);
            } */catch (ArithmeticException ae) {
                lab_SM.setText("Exception on arithmetic");
                System.out.println(ae);
            }
        }
        
        private void output_digit(Button btn) {
            if(btn == digits_SM[10]){ // is point
                lab_SM.setText(lab_SM.getText() + ".");
            }
            else if (continueenterdigit_SM){
                lab_SM.setText(lab_SM.getText() + btn.getLabel());
            }
            else{
                lab_SM.setText(btn.getLabel());
            }            

            System.out.println("press on " + btn.getLabel());
        }

        private void save_num(Button oper) {
            num_SM = Double.parseDouble(lab_SM.getText());
            if (num_SM % 1 == 0) {         // is integer
                String displayonlyinteger = lab_SM.getText().split("\\.")[0];
                lab_SM.setText(displayonlyinteger);
                System.out.println("is integer : " + displayonlyinteger);
            }
            else{
                System.out.println("is not integer" + num_SM);
                lab_SM.setText(Double.toString(0L));
            }
        }        
        
        private void triangle_num(Button oper){
            lab_SM.setText(Double.toString(0));
        }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;  
        }
        
    }

}






