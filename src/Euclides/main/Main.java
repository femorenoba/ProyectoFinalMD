package Euclides.main;

import Euclides.mate.Euclides;
import Euclides.vistas.Pane;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage stage) throws Exception {
	    stage.setTitle("Algoritmo de Euclides para niños");// Titulo de la aplicacion
	    Group root = new Group();
	    Scene scene  = new Scene(root, 1200,480);// Dimensiones de la aplicacion
	    stage.setResizable(false);

	    final Pane form = new Pane();

	    root.getChildren().add(form.getPane());

	    form.getBtnCalc().setOnAction((event) ->{//agreamaos el evento con un lambda
	    	try{
		    	Double first = Double.valueOf(form.getTxtFirstNumber().getText());//obtenemos los textos
		    	Double second = Double.valueOf(form.getTxtSecondNumber().getText());
		    	int result = 0;

		        Euclides euc =  new Euclides();
		        if(first > second){//Se ordenan los numeros
				    result = euc.algoritmo(first, second);
		        }else{
		        	result = euc.algoritmo(second, first);
		        }
			    form.generateTable(euc.lResiduo, euc.lDividendo,euc.lCociente ); //Se genera la tabla del algortimo
	    		form.getLblError().setText("");//Se limpia
	    		form.getLblRes().setText("El M.C.D es igual a : " + String.valueOf(result));//Se muestra el Resultado
	    	}catch(Exception e){
	    		form.getLblError().setText("Solo se permiten números.");//Solo se aceptan numeros
	    		e.printStackTrace();
	    	}
	    });

	    form.getBtnClear().setOnAction((event) -> {//Se limpian las acciones

		    form.getFlow().getChildren().clear();
		    form.getLblError().setText("");
		    form.getLblRes().setText("");
		    form.getTxtFirstNumber().setText("");
		    form.getTxtSecondNumber().setText("");

	    });

	    stage.setScene(scene);
	    stage.show();
	}


	public static void main(String[] args) {
	    launch(args);
	}

}
