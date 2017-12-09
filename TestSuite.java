package application;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class TestSuite {

	Pane pane;
	Main main;
	Double frameX, frameY;
	classBox cbox;
	VBox vbox;
	Polygon p1;
	HBox hbox;
	Ball ball, ball2;
	createTextBox ctb;
	objectMaker<Polygon> maker;

	@Before
	public void setUp() {
		frameX = 800.0;
		frameY = 400.0;
		pane = new Pane();
		main = new Main();
		maker = new objectMaker<Polygon>();
	}

	/*
	 * create a class box and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testAddClassBoxes() {
		cbox = new classBox();
		vbox = (VBox) cbox.createBox();
		pane.getChildren().addAll(vbox);

		assertEquals(1, pane.getChildren().size());
	}

	/*
	 * create a filled diamond and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testCreateFDiamond() {
		maker.setAttributes("arrow", 25, 25, 5, Color.BLACK);
		p1 = (Polygon) maker.createObject("diamond");
		pane.getChildren().addAll(p1);
		ball = new Ball(frameX + 5, frameY + 5, 10);
		ball.setFill(Color.TRANSPARENT);
		pane.getChildren().addAll(ball);

		assertEquals(2, pane.getChildren().size());
	}

	/*
	 * create an empty diamond and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testCreateEDiamond() {
		maker.setAttributes("arrow", 25, 25, 5, Color.rgb(204, 204, 204));
		p1 = (Polygon) maker.createObject("diamond");
		pane.getChildren().addAll(p1);
		ball = new Ball(frameX + 5, frameY + 5, 10);
		ball.setFill(Color.TRANSPARENT);
		pane.getChildren().addAll(ball);

		assertEquals(2, pane.getChildren().size());
	}

	/*
	 * create a filled triangle and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testCreateFTriangle() {
		maker = new objectMaker<Polygon>();
		maker.setAttributes("arrow", 25, 25, 5, Color.rgb(204, 204, 204));
		p1 = (Polygon) maker.createObject("arrow");
		p1.setStrokeWidth(2);
		p1.setStroke(Color.BLACK);
		pane.getChildren().addAll(p1);
		ball = new Ball(frameX + 5, frameY + 5, 10);
		ball.setFill(Color.TRANSPARENT);
		pane.getChildren().addAll(ball);

		assertEquals(2, pane.getChildren().size());
	}

	/*
	 * create an empty triangle and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testCreateETriangle() {
		maker = new objectMaker<Polygon>();
		maker.setAttributes("arrow", 25, 25, 5, Color.rgb(204, 204, 204));
		p1 = (Polygon) maker.createObject("arrow");
		p1.setStrokeWidth(2);
		p1.setStroke(Color.BLACK);
		pane.getChildren().addAll(p1);
		ball = new Ball(frameX + 5, frameY + 5, 10);
		ball.setFill(Color.TRANSPARENT);
		pane.getChildren().addAll(ball);

		assertEquals(2, pane.getChildren().size());
	}

	/*
	 * create a dashed line and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testCreateDashedLine() {
		ball = new Ball(frameX, frameY, 10);
		ball.setFill(Color.BLACK);
		pane.getChildren().addAll(ball);
		ball2 = new Ball(frameX + 5, frameY + 5, 10);
		ball2.setFill(Color.TRANSPARENT);
		pane.getChildren().addAll(ball2);

		assertEquals(2, pane.getChildren().size());
	}

	/*
	 * create a line and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testCreateLine() {
		ball = new Ball(frameX, frameY, 10);
		ball.setFill(Color.TRANSPARENT);
		pane.getChildren().addAll(ball);
		ball2 = new Ball(frameX + 5, frameY + 5, 10);
		ball2.setFill(Color.BLACK);
		pane.getChildren().addAll(ball2);
		
		assertEquals(2, pane.getChildren().size());
	}
	
	/*
	 * create a line and add it to the pane then check the pane for the
	 * expected children
	 */
	@Test
	public void testTestBox() {
		ctb = new createTextBox();
		hbox = (HBox) ctb.display(frameX, frameY);
		pane.getChildren().addAll(hbox);
		
		assertEquals(1, pane.getChildren().size());
	}
	
}