import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cell extends Rectangle{
    private static int size = 70;
    protected int col;
    protected int row;
    protected Color backbgroundColor;
    protected Color textColor;
    protected char displayCharacter;
    protected boolean isEmpty;
    protected boolean isActive;

    public Cell(){
        super(0,0,0,0);
        col = -1;
        row = -1;
        displayCharacter = ' ';
        backbgroundColor = Color.DARK_GRAY;
        textColor = Color.WHITE;
        isEmpty = true;
    }

    public Cell(int columnIndex, int rowIndex, int inX, int inY){
        super(inX,inY,size,size);
        col = columnIndex;
        row = rowIndex;
        displayCharacter = ' ';
        backbgroundColor = Color.DARK_GRAY;
        textColor = Color.WHITE;
        isEmpty = true;
    }

    public void setCharacter(char letter, int cellState){
        //cell state 0 is empty
        //cell state 1 is letter entered
        //cell state 2 is letter entered, yellow background
        //cell state 3 is letter entered, green background
        switch(cellState){

            //removed redundant code
            case 1:

                cellStateFix(letter, Color.DARK_GRAY, Color.WHITE, false);
                
                break;
            case 2:

                cellStateFix(letter, Color.YELLOW, Color.BLACK, false);
                
                break;
            case 3:

                cellStateFix(letter, Color.GREEN, Color.BLACK, false);
                
                break; 
            case 4:

                cellStateFix(letter, Color.RED, Color.WHITE, false);
                
                break; 
            default:

                cellStateFix(' ', Color.DARK_GRAY, Color.WHITE, true);
                
        }
    }

    void setState(int cellState){
        setCharacter(displayCharacter,cellState);
    }

    void paint(Graphics g){

        //Remove complex boolean statement

        if(isActive){
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(backbgroundColor);
        }
        
        g.fillRect(x,y,size,size);
        
        if(isActive){
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawRect(x, y, size, size);
        
        
        if(isActive){
            g.setColor(Color.BLACK);
        } else {
            g.setColor(textColor);
        }
        
        Font f = new Font("Arial", Font.PLAIN, 40);
        FontMetrics metrics = g.getFontMetrics(f);
        int drawXPos = x + ((size - metrics.stringWidth(""+displayCharacter))/2);
        int drawYPos = y + ((size + metrics.getHeight())/2 - 10);
        
        g.setFont(f); 
        g.drawString(""+displayCharacter, drawXPos, drawYPos);
    }

    void setActive(){
        isActive = true;
    }

    void setInactive(){
        isActive = false;
    }

    void reset(){
        setCharacter(' ', 0);
    }

    public String getStoredCharacter(){
        return "" + displayCharacter;
    }

        //Removed all toString() function

    public void cellStateFix(char x, Color y, Color z, boolean a){
                displayCharacter = x;
                backbgroundColor = y;
                textColor = z;
                isEmpty = a;

    }
}
