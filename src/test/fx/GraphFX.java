package test.fx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GraphFX extends Application {
    Canvas unCanvas;
    double oldx = 0, oldy = 0;
    Image[][] pieces;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadAssets();

        unCanvas = new Canvas(960, 960);
//        unCanvas.setOnMouseClicked(e -> {
//            unCanvas.getGraphicsContext2D().strokeLine(oldx, oldy, e.getX(), e.getY());
//            oldx = e.getX();
//            oldy = e.getY();
//        });

        GraphicsContext gc = unCanvas.getGraphicsContext2D();

        boolean color = true;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (color) {
                    gc.setFill(Paint.valueOf("black"));
                } else gc.setFill(Paint.valueOf("white"));
                gc.fillRect(120 * row, 120 * col, 120, 120);
                color = !color;
            }
            color = !color;
        }

        gc.drawImage(pieces[0][0], 120, 120);

        HBox hbox = new HBox();
        hbox.getChildren().add(unCanvas);

        primaryStage.setScene(new Scene(hbox));

        primaryStage.show();
    }

    private void loadAssets() {
        try {
            Image imagePieces = new Image("/assets/Chess/ChessPieces.png", false);
            // Cut the Piece
            int h = (int) imagePieces.getHeight();
            int w = (int) imagePieces.getWidth();
            int pieceHeight = h / 2;
            int pieceWidth = w / 6;

            this.pieces = new Image[2][6];
            PixelReader reader = imagePieces.getPixelReader();
            for (int x = 0; x < 6; x++) {
                this.pieces[0][x] = new WritableImage(reader, x * pieceWidth, 0, pieceWidth, pieceHeight);
                this.pieces[1][x] = new WritableImage(reader, (5 - x) * pieceWidth, pieceHeight, pieceWidth, pieceHeight);
            }

        } catch (Exception e) {
            System.err.println("Null Pointer Exception");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }

}
