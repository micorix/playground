package com.micorix.general;


import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SimpleShootingGame {
    final int CANVAS_SIZE = 1000;
    final int CANVAS_SCALE = 10;
    final int CIRCLES_NO = 15;
    final double BASE_RADIUS = (double) this.CANVAS_SCALE / (double) this.CIRCLES_NO;

    final Color ACTIVE_CIRCLE_BG_COLOR = StdDraw.RED;
    final Color EVEN_CIRCLE_BG_COLOR = StdDraw.GRAY;
    final Color ODD_CIRCLE_BG_COLOR = StdDraw.WHITE;
    final Color BORDER_COLOR = EVEN_CIRCLE_BG_COLOR;

    int activeCircleIndex = -1;

    public static void main(String[] args) {
        SimpleShootingGame game = new SimpleShootingGame();
        game.setupCanvas();

        while (true) {
            if (StdDraw.isMousePressed())
                game.handleClick();

            game.renderFrame();
        }
    }

    private void handleClick() {
        double distanceToCenter = Math.hypot(StdDraw.mouseX(), StdDraw.mouseY());

        if (distanceToCenter < this.CIRCLES_NO) {
            activeCircleIndex = (int) Math.ceil(distanceToCenter / BASE_RADIUS);

            blinkAndHide(activeCircleIndex);
        }
    }


    private void blinkAndHide(int circleIndex, int i) {
        CompletableFuture.delayedExecutor(200, TimeUnit.MILLISECONDS).execute(() -> {
            activeCircleIndex = i % 2 == 0 ? -1 : circleIndex;
            if (i > 0) blinkAndHide(circleIndex, i - 1);
        });
    }

    private void blinkAndHide(int circleIndex) {
        blinkAndHide(circleIndex, 4);
    }

    private void renderBoard (){
        int lastIndex = CIRCLES_NO - 1;
        double borderWidth = 0.001;

        for (int i = lastIndex; i >= 0; i-=1) {
            if (activeCircleIndex == i) {
                StdDraw.setPenColor(ACTIVE_CIRCLE_BG_COLOR);
                StdDraw.filledCircle(0, 0, i * BASE_RADIUS + borderWidth);
            } else{
                StdDraw.setPenColor(i % 2 == 0 ? EVEN_CIRCLE_BG_COLOR : ODD_CIRCLE_BG_COLOR);
                StdDraw.filledCircle(0, 0, i * BASE_RADIUS);
                StdDraw.setPenColor(BORDER_COLOR);
                StdDraw.circle(0, 0, i * BASE_RADIUS + borderWidth);
            }
        }

        StdDraw.setPenColor(BORDER_COLOR);
        StdDraw.filledCircle(0, 0, BASE_RADIUS/2);
    }

    private void renderFrame() {
        StdDraw.clear();

        renderBoard();

        String targetIconPath = "./assets/target-icon.png";
        StdDraw.picture(StdDraw.mouseX(), StdDraw.mouseY(), targetIconPath, 1, 1);

        StdDraw.show();
    }

    private void setupCanvas() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setScale(-CANVAS_SCALE, CANVAS_SCALE);
    }
}
