import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.awt.Color;
import java.util.*;
import java.awt.geom.*; 
import java.awt.image.*; 
import java.awt.Shape; 
import java.awt.RenderingHints; 
import java.awt.font.FontRenderContext; 
import java.awt.font.TextLayout; 
import java.awt.List;

public class ImageProcess extends Frame //implements ActionListener
{ 

Button b1;
Button b2;
Button b3;
Button b4;
Button b5;
Button b6;
Button b7;
Button x,y;
BufferedImage img=null;
File f=null;
int width,height,p,a,r,g,b;
public String path;
String path1,path2;
JLabel l;
DefaultListModel<String> l1; 
JList<String> list1; 

void selection()
{
	if(list1.getSelectedIndex()!=-1 && list1.getSelectedValue().equals("CuteCat"))
	{path="cutecat.jpg";
              path1="C:\\Users\\Harika\\Pictures\\cutecat.jpg";
              }
    else if(list1.getSelectedIndex()!=-1 && list1.getSelectedValue().equals("FierceFox"))
		{path="fiercefox.jpg";
                             path1="C:\\Users\\Harika\\Pictures\\fiercefox.jpg";
                             }

	else if(list1.getSelectedIndex()!=-1 && list1.getSelectedValue().equals("TeddyLady"))
{
	path="teddylady.jpg";
              path1="C:\\Users\\Harika\\Pictures\\teddylady.jpg";
}
else if(list1.getSelectedIndex()!=-1 && list1.getSelectedValue().equals("Vacay"))
{
	path="vacay.jpg";
              path1="C:\\Users\\Harika\\Pictures\\vacay.jpg";
}
else if(list1.getSelectedIndex()!=-1 && list1.getSelectedValue().equals("Vortex"))
{
path="vortex.jpg";
path1="C:\\Users\\Harika\\Pictures\\vortex.jpg";
}
}

void replace(String path,String path1)
{    
try{
      f = new File(path1); //image file path
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println("Error: "+e);
    }

    //write image
    try{
      f = new File(path);  //output file path
      ImageIO.write(img, "jpg", f);
    }catch(IOException e){
      System.out.println("Error: "+e);
    }

}

public ImageProcess()
{
//JPanel pa=new JPanel();
setLayout(new FlowLayout());
l=new JLabel("Select an image from the given data set");
l.setBounds(50,100,600,30);
l.setFont(new Font("Courier New", Font.BOLD, 25));
l.setForeground(Color.WHITE);

  setLayout(null);
b1=new Button("Convert into Grayscale");
b1.setBounds(180,300,400,30);
b2=new Button("Convert into Red dominant Image");
b2.setBounds(180,350,400,30);
b3=new Button("Convert into green dominant image");
b3.setBounds(180,400,400,30);
b4=new Button("Convert into blue dominant image");
b4.setBounds(180,450,400,30);
b5=new Button("Convert into negative");
b5.setBounds(180,500,400,30);
b6=new Button("Revert back to original");
b6.setBounds(180,550,400,30);
x=new Button("Show the processed Image");
b7=new Button("Create a mirror image");
b7.setBounds(180,600,400,30);
x.setBounds(700,400,250,30);
y=new Button("Show the Original Image");
y.setBounds(700,300,250,30);

add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(b7);
add(x);
add(y);
//add(tf);

    

l1=new DefaultListModel<String>();
list1=new JList<String>(l1);
//List list1=new List(5);
l1.addElement("CuteCat");  
l1.addElement("FierceFox");  
l1.addElement("TeddyLady"); 
l1.addElement("Vacay");
l1.addElement("Vortex");
list1.setBounds(230,150,500,120); 
add(list1);

setLayout(null);  
setVisible(true);  
 
b1.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)//throws IOException
{
//path=list1.getSelectedValue();

selection();
try
{
f=new File(path);
img=ImageIO.read(f);
}
catch(IOException er)
{
System.out.println(er);
}
 width=img.getWidth();
 height=img.getHeight();
for(int i=0;i<width;i++)
{
for(int j=0;j<height;j++)
{
 p=img.getRGB(i,j);
 a=(p>>24)&0xFF;
 r=(p>>16)&0xFF;
 g=(p>>8)&0xFF;
 b=(p)&0xFF;
int avg=(r+g+b)/3;
p=(a<<24)|(avg<<16)|(avg<<8)|(avg);
img.setRGB(i,j,p);
}
}
try{
f=new File(path);
ImageIO.write(img,"jpg",f);
}
catch(IOException er)
{
System.out.println(er);
}
}
});
b2.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent e)//throws IOException
{
 selection();
//displayoriginal();
 //path=list1.getSelectedValue();
try
{
f=new File(path);
img=ImageIO.read(f);
}
catch(IOException er)
{
System.out.println(er);
}
 width=img.getWidth();
 height=img.getHeight();
for(int x=0;x<width;x++)
{
for(int y=0;y<height;y++)
{
 p=img.getRGB(x,y);
 a=(p>>24)&0xFF;
 r=(p>>16)&0xFF;
 g=(p>>8)&0xFF;
 b=(p)&0xFF;
p=(a<<24)|(r<<16)|(0<<8)|(0);
img.setRGB(x,y,p);
}
}
try{
f=new File(path);
ImageIO.write(img,"jpg",f);
}
catch(IOException er)
{
System.out.println(er);
}
}
});
b3.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
 selection();
//displayoriginal();
 //path=list1.getSelectedValue();
try
{
f=new File(path);
img=ImageIO.read(f);
}
catch(IOException er)
{
System.out.println(er);
}
 width=img.getWidth();
 height=img.getHeight();
for(int x=0;x<width;x++)
{
for(int y=0;y<height;y++)
{
 p=img.getRGB(x,y);
 a=(p>>24)&0xFF;
 r=(p>>16)&0xFF;
 g=(p>>8)&0xFF;
 b=(p)&0xFF;
p=(a<<24)|(0<<16)|(g<<8)|(0);
img.setRGB(x,y,p);
}
}
try{
f=new File(path);
ImageIO.write(img,"jpg",f);
}
catch(IOException er)
{
System.out.println(er);
}
}
});
b4.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
	selection();
//displayoriginal();
 //path=list1.getSelectedValue();
try
{
f=new File(path);
img=ImageIO.read(f);
}
catch(IOException er)
{
System.out.println(er);
}
 width=img.getWidth();
 height=img.getHeight();
for(int x=0;x<width;x++)
{
for(int y=0;y<height;y++)
{
 p=img.getRGB(x,y);
 a=(p>>24)&0xFF;
 r=(p>>16)&0xFF;
 g=(p>>8)&0xFF;
 b=(p)&0xFF;
p=(a<<24)|(0<<16)|(0<<8)|(b);
img.setRGB(x,y,p);
}
}
try{
f=new File(path);
ImageIO.write(img,"jpg",f);
}
catch(IOException er)
{
System.out.println(er);
}
}
});
b5.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
	selection();
//displayoriginal();
 //path=list1.getSelectedValue();
try
{
f=new File(path);
img=ImageIO.read(f);
}
catch(IOException er)
{
System.out.println(er);
}
 width=img.getWidth();
 height=img.getHeight();
for(int x=0;x<width;x++)
{
for(int y=0;y<height;y++)
{
 p=img.getRGB(x,y);
 a=(p>>24)&0xFF;
 r=(p>>16)&0xFF;
 g=(p>>8)&0xFF;
 b=(p)&0xFF;
 r=255-r;
 g=255-g;
 b=255-b;
p=(a<<24)|(r<<16)|(g<<8)|(b);
img.setRGB(x,y,p);
}
}
try{
f=new File(path);
ImageIO.write(img,"jpg",f);
}
catch(IOException er)
{
System.out.println(er);
}
}
});

b6.addActionListener(new ActionListener()
{ public void actionPerformed(ActionEvent e)
{ replace(path,path1);
}
});
b7.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
	selection();
//displayoriginal();
 //path=list1.getSelectedValue();
try
{
f=new File(path);
img=ImageIO.read(f);
}
catch(IOException er)
{
System.out.println(er);
}
 width=img.getWidth();
 height=img.getHeight();
BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
    //create mirror image pixel by pixel
    for(int y = 0; y < height; y++){
      for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
        //lx starts from the left side of the image
        //rx starts from the right side of the image
        //get source pixel value
         p = img.getRGB(lx, y);
        //set mirror image pixel value - both left and right
        mimg.setRGB(lx, y, p);
        mimg.setRGB(rx, y, p);
      }
    }
	try{
f=new File(path);
ImageIO.write(mimg,"jpg",f);
}
catch(IOException er)
{
System.out.println(er);
}
}
});

x.addActionListener(new ActionListener()
{ public void actionPerformed(ActionEvent e)
{
String IMG_PATH=path;
                            JFrame frame=new JFrame();
                              try{
		BufferedImage img = ImageIO.read(new File(IMG_PATH));
		ImageIcon icon = new ImageIcon(img);
		JLabel label = new JLabel(icon);
 
		frame.add(label);  

		frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		frame.setVisible(true);

}

catch(IOException er)
{
System.out.println(er);
}

replace(path,path1);
  }
});

y.addActionListener(new ActionListener()
{ public void actionPerformed(ActionEvent e)
{
selection();
String IMG_PATH=path1;
                            JFrame frame2=new JFrame();
                              try{
		BufferedImage img2 = ImageIO.read(new File(IMG_PATH));
		ImageIcon icon2 = new ImageIcon(img2);
		JLabel label2 = new JLabel(icon2);
 
		frame2.add(label2);  

		frame2.setExtendedState( frame2.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		frame2.setVisible(true);
                           
}

catch(IOException er)
{
System.out.println(er);
}

  }
});
setBackground(new Color(25,25,112));
b1.setBackground(new Color(173,216,230));
b3.setBackground(new Color(173,216,230));
b5.setBackground(new Color(173,216,230));
x.setBackground(new Color(173,216,230));
//b1.setForeground(Color.green);
b1.setFont(new Font("Bold Italic", Font.BOLD, 12));
b2.setFont(new Font("Bold Italic", Font.BOLD, 12));
b3.setFont(new Font("Bold Italic", Font.BOLD, 12));
b4.setFont(new Font("Bold Italic", Font.BOLD, 12));
b5.setFont(new Font("Carbon Block", Font.BOLD, 12));
b6.setFont(new Font("Carbon Block", Font.BOLD, 12));
x.setFont(new Font("Carbon Block", Font.BOLD, 12));
y.setFont(new Font("Carbon Block", Font.BOLD, 12));

}

public static void main(String args[])
{ImageProcess ip=new ImageProcess();
ip.setSize(500,500);
ip.setVisible(true);
}
 
public void paint(Graphics g)
{


//setFont(new Font("Carbon Block", Font.BOLD, 18));
setForeground(Color.WHITE);
Graphics2D G2D = (Graphics2D)g; 
                int w = getSize().width; 
                int h = getSize().height; 
                Image image = (new ImageIcon("Webp.net-resizeimage.png")).getImage(); 
                G2D.drawImage(image,150,50,this); 
                FontRenderContext FontRC = G2D.getFontRenderContext(); 
                Font font = new Font("Black",Font.ITALIC,w/50); 
                String str = new String ("Select an item from the list"); 
                TextLayout TextL = new TextLayout(str,font,FontRC); 
                float sw = (float)TextL.getBounds().getWidth(); 
                G2D.setColor(Color.white); 
            
               TextL.draw(G2D,250,130); 

}
}