import processing.core.PApplet;

public class Bubble {
    float x;
    float y;
    int health;
    PApplet canvas;
    float diameter;
    float speed;
    int color;

    public Bubble(PApplet c, float initialX, float initialY){
        diameter = 50;
        canvas = c;
        x = initialX;
        y = initialY;
        
        color = canvas.color(0, 255, 0);
        health = 4;
        speed = 10;
    }

    public void display(){
        canvas.fill(color);
        canvas.circle(x, y, diameter);
    }

    public void randomSpeed(){
        speed = canvas.random(15)+1;
    }

    public void update(){

        x += speed;
        
        if(x >= canvas.width){
            x= 0;
        }
    }
    public void randomSize(){
        diameter = canvas.random(100) + 25;
    }

    public void changeSize(int change){
        diameter += change;
    }

    public void randomColor(){
        color = canvas.color(canvas.random(255),canvas.random(255),canvas.random(255));
    }

    public boolean touching(float x, float y){
        // System.out.println("running!");
        float distanceX = this.x - x;
        float distanceY = this.y - y;
        float distance = (float)Math.sqrt(distanceX*distanceX + distanceY*distanceY);
        if(distance < diameter/2){
            
            health--;
            
            return true;
        }else{
            return false;
        }
    }
}
