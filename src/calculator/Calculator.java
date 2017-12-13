package calculator;

import java.awt.*;
import java.awt.event.*;
public class Calculator {

	    private static Frame frm=new Frame("Calculator");
	    private static Panel pn1=new Panel(new GridLayout(5,3));
	    private static Panel pn2=new Panel(new GridLayout(5,1));
	    private static Label lab=new Label("0",Label.RIGHT);
	    // clear, add, sub, mul, div, equ, module
	    private static Button clean,ad,sub,mul,div,equ,mod;
	    // number 0 to 9
	    private static Button digits[]=new Button[10];
	    private static long num;    // store the results
	    private static byte op;     // operator

	public static void main(String args[])
	{
	    frm.setLayout(null);
	    frm.setBounds(450,250,320,360);

	    frm.setResizable(false);
	    lab.setBounds(30,40,250,40);
	    lab.setBackground(new Color(240,220,190));
	    pn1.setBounds(30,100,180,210);
	    pn2.setBounds(220,100,60,210);
	    // number 0 - 9
	    for(int i=9;i>=0;i--){
	        digits[i]=new Button(Integer.toString(i));
	        pn1.add(digits[i]);
	        digits[i].addActionListener(new ActLis());
	    }
	    //清除鈕
	    clean=new Button("C");
	    pn1.add(clean);
	    clean.addActionListener(new ActLis());
	    //等於鈕
	    equ=new Button("=");
	    pn1.add(equ);
	    equ.addActionListener(new ActLis());
	    //加鈕
	    ad=new Button("+");
	    pn2.add(ad);
	    ad.addActionListener(new ActLis());
	    //減鈕
	    sub=new Button("-");
	    pn2.add(sub);
	    sub.addActionListener(new ActLis());
	    //乘鈕
	    mul=new Button("*");
	    pn2.add(mul);
	    mul.addActionListener(new ActLis());
	    //除鈕
	    div=new Button("/");
	    pn2.add(div);
	    div.addActionListener(new ActLis());
	    
	    frm.addWindowListener(new WindowAdapter(){public void
	    windowClosing(WindowEvent e){System.exit(0);}});   
	    frm.add(lab);
	    frm.add(pn1);
	    frm.add(pn2);
	    frm.setVisible(true);
	}

	public static class ActLis implements ActionListener
	{
	    public void actionPerformed(ActionEvent e)throws NumberFormatException,ArithmeticException{
	        long result;//存放由字串轉成的數值
	           
	            Button btn=(Button) e.getSource();
	            try{
	                  //處理數值1-9
	                  for(int i=0;i<=9;i++){
	                      if(btn==digits[i]){
	                          output_digit(digits[i]);
	                          break;
	                      }
	                  }
	                  if(btn==clean){
	                      result=0L;//把儲存的結果歸0
	                     num=0L;
	                      op=0;
	                      lab.setText(Long.toString(num));
	                  }else if(btn==ad){//加
	                      save_num(ad);
	                      op=1;
	                  }else if(btn==sub){//減
	                      save_num(sub);
	                      op=2;
	                  }else if(btn==mul){//乘
	                      save_num(mul);                    
	                      op=3;
	                  }else if(btn==div){//除
	                      save_num(div);
	                      op=4;
	                  }else if(btn==equ){
	                      result=Long.parseLong(lab.getText());
	                  
	                      switch(op){
	                          case 1:
	                              num+=result;
	                          break;
	                      case 2:
	                              num-=result;
	                              break;
	                          case 3:
	                              num*=result;
	                              break;
	                          case 4:
	                              num/=result;
	                              break;
	                          default:
	                      }
	                      result=0L;
	                      //輸出運算後的結果到顯示器
	                      lab.setText(Long.toString(num));
	                  }
	       }catch(NumberFormatException ne){
	           //捕捉例外
	        }catch(ArithmeticException ae){
	            //捕捉被除數是零的例外
	        }    
	    }
	      //輸出數值到顯示器
	      private void output_digit(Button btn){
	    lab.setText(Long.toString(Long.parseLong(lab.getText()+btn.getLabel())));
	    }
	       //把第一組數值儲存起來
	      private void save_num(Button oper){
	          num=Long.parseLong(lab.getText());
	           lab.setText(Long.toString(0L));
	      }
	}	
	
	
	
}
