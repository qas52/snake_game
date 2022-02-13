package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class program extends JPanel implements KeyListener ,ActionListener {
       private ImageIcon title,upface,downface,rightface,leftface,enemy,body;

      private int d=0,score=0,moves =0, snakelength=3;
      private int snakexpos[] = new int[750];
      private int snakeypos[] = new int[750];
    private int[] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};

    private int[] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};

    private Random random = new Random();
    private int x =random.nextInt(34);
    private int y= random.nextInt(23);

    private boolean left= false;
      private boolean right= false;
      private boolean up= false;
      private boolean down= false;

private Timer timer;
private int delay = 100;



public program(){

    addKeyListener(this);
    setFocusable(true);

    timer= new Timer(delay , this);
    timer.start();


}

     public void paint(Graphics g)
    {   g.setColor(Color.WHITE);

        title = new ImageIcon("snake (2).jpg");
        title.paintIcon(this,g,360,11);
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);

       g.setColor(Color.BLACK);
       g.fillRect(25,75,850,575);

g.setColor(Color.BLUE);
g.setFont(new Font ("arial", Font.PLAIN,15));
g.drawString("SCORE is  "+ score,750,50);
repaint();

        enemy = new ImageIcon("enemy.png");
        enemy.paintIcon(this,g,enemyxpos[x],enemyypos[y]);
       if (moves ==0)
       {
           snakexpos[2]= 50;
           snakexpos[1]=75;
           snakexpos[0]=100;
           snakeypos[2]=100;
           snakeypos[1]=100;
           snakeypos[0]=100;

       }
        rightface = new ImageIcon("rightmouth.png");
        rightface.paintIcon(this,g,snakexpos[0],snakeypos[0]);

       for( int a=0;a<snakelength;a++)
       {
           if(a==0 && right)
           {
               rightface = new ImageIcon("rightmouth.png");
               rightface.paintIcon(this,g,snakexpos[a],snakeypos[a]);

           }
           if(a==0 && left)
           {
               leftface = new ImageIcon("leftmouth.png");
               leftface.paintIcon(this,g,snakexpos[a],snakeypos[a]);
           }
           if(a==0 && up)
           {
               upface = new ImageIcon("upmouth.png");
               upface.paintIcon(this,g,snakexpos[a],snakeypos[a]);

               }
               if (a==0 && down)
               {
                   downface = new ImageIcon("downmouth.png");
                   downface.paintIcon(this,g,snakexpos[a],snakeypos[a]);

               }
               if(a!=0)
               {
                   body = new ImageIcon("snakeimage.png");
                   body.paintIcon(this,g,snakexpos[a],snakeypos[a]);

               }
               }
if(enemyxpos[x]==snakexpos[0] && enemyypos[y]== snakeypos[0])
{     score++;
     snakelength++;
    x= random.nextInt(34);
       y=random.nextInt(23);}
       for( int b=1; b<snakelength;b++){
       if(snakexpos[b]==snakexpos[0] && snakeypos[b]==snakeypos[0])
       {
             right=false;
         left=false;
         up=false;
         down=false;

d=1;

       g.setColor(Color.WHITE);
       g.setFont(new Font("arial", Font.BOLD,60));
       g.drawString("GAME OVER ",300,300);

           g.setFont(new Font("arial", Font.BOLD,30));
           g.drawString(" Press Space to RESTART ",320,340);

           g.setFont(new Font("arial", Font.BOLD,20));
           g.drawString(" FINAL SCORE " + score,330,360);

       }}

g.dispose();
    }


    public void actionPerformed(ActionEvent e)
    {   timer.start();

        if(d==0 &&right)
        {
            moves++;
            for( int x=snakelength-1;x>=0;x--)
            {
                snakeypos[x+1]=snakeypos[x];
            }
            for( int x= snakelength;x>=0;x--)
            {
                if(x==0)
                {
                    snakexpos[x]=snakexpos[x]+25;
                }
                else{
                    snakexpos[x]=snakexpos[x-1];
                    }
                    if(snakexpos[x]>850)
                        snakexpos[x]=25;

            }repaint();
        }
        if(d==0&&left)
        {   moves++;
            for( int x= snakelength-1;x>=0;x--)
            {
                snakeypos[x+1]=snakeypos[x];
            }
            for( int x= snakelength;x>=0;x--)
            {
                if(x==0)
                {
                    snakexpos[x]=snakexpos[x]-25;
                }
                else{
                    snakexpos[x]=snakexpos[x-1];
                }
                if(snakexpos[x]<25)
                    snakexpos[x]=850;

            }repaint();
        }
        if(d==0&&up)
        {   moves++;
            for( int x= snakelength-1;x>=0;x--)
            {
                snakexpos[x+1]=snakexpos[x];
            }
            for( int x= snakelength;x>=0;x--)
            {
                if(x==0)
                {
                    snakeypos[x]=snakeypos[x]-25;
                }
                else{
                    snakeypos[x]=snakeypos[x-1];
                }if(snakeypos[x]<75)
                    snakeypos[x]=625;

            }repaint();
        }
        if(d==0&&down)
        {   moves++;
            for( int x= snakelength-1;x>=0;x--)
            {
                snakexpos[x+1]=snakexpos[x];
            }
            for( int x= snakelength;x>=0;x--)
            {
                if(x==0)
                {
                    snakeypos[x]=snakeypos[x]+25;
                }
                else{
                    snakeypos[x]=snakeypos[x-1];
                }if(snakeypos[x]>625)
                    snakeypos[x]=75;

            }
            repaint();
        }




    }
    public void keyTyped(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {   if(e.getKeyCode()==KeyEvent.VK_SPACE)
    {d=0;
        snakelength=3;
        score=0;
        moves=0;

repaint();



    }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
            if(!left)
                right=true;
            else
            right= false;
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(!right)
                left=true;
            else
               left=false;
               up=false;
               down=false;
        }
        if (e.getKeyCode()==KeyEvent.VK_UP)
        {
            if(!down)
                up=true;
            else
                up=false;
            left=false;
            right=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            if(!up)
                down=true;
            else
                down=false;
            left=false;
            right=false;

        }

    }
    public void keyReleased(KeyEvent e)
    {

    }


    public static void main(String args[])
    {   program prog = new program();
        JFrame frame = new JFrame();
        frame.setBounds(10,10,905,700);
        frame.setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(prog);


    }
}