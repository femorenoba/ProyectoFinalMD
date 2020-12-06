package Euclides.vistas;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Pane {
	public static int ROWS = 2;
	private BorderPane border;
	private ScrollPane scroll;
	private GridPane grid;
	private GridPane flow;
	private Label lblN1;
	private Label lblN2;
	private Label lblError;
	private Label lblRes;
	private Label lblNota;
	private TextField tfFirstNumber;
	private TextField tfSecondNumber;
	private Button btnCalc;
	private Button btnClear;

	public Pane(){
		border = new BorderPane();
		border.setPrefHeight(450);
		grid = new GridPane();
		flow = new GridPane();
		scroll = new ScrollPane(flow);

		scroll.setPrefWidth(700);

		initGrid();
		initFlow();

		border.setLeft(grid);
		border.setRight(scroll);
	}

	private void initGrid(){
		lblN1 			= new Label("Primer número:");
		tfFirstNumber 	= new TextField();
		lblN2 			= new Label("Segundo número:");
		tfSecondNumber 	= new TextField();
		btnCalc 		= new Button("Calcular");
		btnClear		= new Button(" Borrar");
		lblError		= new Label();
		lblRes			= new Label();
		lblNota         = new Label("Nota: Cocientes en azul, Divisores en Verde, Residuos en Rojo");

		lblError.setTextFill(Color.web("#f44336"));
		lblRes.setTextFill(Color.web("#4caf50"));

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(12);
		grid.setPadding(new Insets(0,20,0,20));

		tfFirstNumber.setPrefWidth(75);
		tfSecondNumber.setPrefWidth(75);

	    grid.add(lblN1, 0, 0);
	    grid.add(tfFirstNumber, 1, 0);
	    grid.add(lblN2, 0, 1);
	    grid.add(tfSecondNumber, 1, 1);
	    grid.add(btnCalc, 0, 2);
	    grid.add(btnClear, 1, 2);
	    grid.add(lblError,0,3,2,1);
	    grid.add(lblRes,0,4,2,1);
	    grid.add(lblNota,0,6,2,1);
	}

	private void initFlow(){
		flow.setHgap(80);
		flow.setVgap(80);
		flow.setAlignment(Pos.CENTER);
		flow.setPadding(new Insets(50,50,50,50));

	}

	public void generateTable(List<Integer> res, List<Integer> div, List<Integer> coc){
		EuclidesRectangle f = new EuclidesRectangle("","white");//primer rectanglo del cociente vacio
        flow.add(f,0,0);
        f.animate();
		this.flow.getChildren().clear();

		for(int i = 1 ; i <= coc.size() ; i++){//agregamos los cocientes
			String result = String.valueOf(coc.get(i-1));
			EuclidesRectangle rect = new EuclidesRectangle(result,"blue");
	        flow.add(rect,i,0);
	        rect.animate();

		}
		for(int i = 0 ; i < div.size() ; i++){//agregamos los divisores
			String result = String.valueOf(div.get(i));
			EuclidesRectangle rect = new EuclidesRectangle(result,"green");
	        flow.add(rect,i,1);
	        rect.animate();

		}
		for(int i = 0 ; i < res.size() ; i++){//agregamos los residuos
			String result = String.valueOf(res.get(i));
			EuclidesRectangle rect = new EuclidesRectangle(result,"red");
	        flow.add(rect,i,2);
	        rect.animate();

		}


	}
	public BorderPane getPane(){
		return border;
	}
	public GridPane getGrid(){
		return grid;
	}
	public GridPane getFlow(){
		return flow;
	}
	public TextField getTxtFirstNumber(){
		return tfFirstNumber;
	}
	public TextField getTxtSecondNumber(){
		return tfSecondNumber;
	}
	public Label getLblError(){
		return lblError;
	}
	public Label getLblRes(){
		return lblRes;
	}
	public Button getBtnCalc(){
		return btnCalc;
	}
	public Button getBtnClear(){
		return btnClear;
	}

}
