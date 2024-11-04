import java.util.ArrayList;

import processing.core.PApplet;

public class App extends PApplet {
    ArrayList<Bubble> bubbles;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        bubbles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            float x = random(width);
            float y = random(height) * .9f + height*.1f;
            Bubble temp = new Bubble(this, x, y);
            bubbles.add(temp);
        }
        
        textSize(40);
    }

    public void settings() {
        size(1920 , 1080);

    }

    public void draw() {
        background(200);
        fill(255);
        textAlign(CENTER);

        text("s = change speed    space = size   c = color   UP = increase size   DOWN = decrease size", width/2, 50);
       
        for (Bubble b : bubbles) {
            b.update();
            b.display();

        }

    }

    public void keyPressed(){
        if(key == ' '){
            for(Bubble b: bubbles){
                b.randomSize();
            }
        }

        if(key == 's'){
            for(Bubble b: bubbles){
                b.randomSpeed();
            }
        }

        if(key == 'c'){
            for(Bubble b: bubbles){
                b.randomColor();
            }
        }

        if(keyCode == UP){
            for(Bubble b: bubbles){
                b.changeSize(5);
            }
        }

        if (keyCode == DOWN){
            for(Bubble b: bubbles){
                b.changeSize(-5);
            }
        }
    }

    public void mousePressed() {
        for (Bubble b : bubbles) {
            if (b.touching(mouseX, mouseY)) {
                System.out.println("hi");
            }
        }
    }

}
