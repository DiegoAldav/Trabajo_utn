package trabajoIntegrador;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Ronda {

    public static void main(String[] args) throws Exception {
        String archivo = "/home/mustafa/trabajoIntegrador/resultados.csv";

        /*for (String linea : Files.readAllLines(Paths.get(archivo))) {
            System.out.println(linea);
        }*/

        List<String> idpartidos = Files.readAllLines(Paths.get(archivo));

        //String[] id1 = idpartidos.get(1).split(",");
        int s1 = -1;
        int s2 = 0;

        //   PRONOSTICOS

        String archivo1 = "/home/mustafa/trabajoIntegrador/pronostico.csv";

        List<String> idpronosticos = Files.readAllLines(Paths.get(archivo1));

        int puntosJugador1 = 0;


        for (int x = 1; x < idpartidos.size(); x++) {
            String[] idx = idpartidos.get(x).split(",");
            //System.out.println(idx[1] + " vs " + idx[4]);
            //System.out.println("partido n° "+x);

            if(true) {s1+=2;}
            if (true) {s2+=2;}

            Equipo equips1 = new Equipo(idx[1], "");
            Equipo equips2 = new Equipo(idx[4], "");

            //System.out.println(equips1.getNombre());
            //System.out.println(equips2.getNombre());

            int egs1 = Integer.parseInt(idx[2]);
            int egs2 = Integer.parseInt(idx[3]);

            //System.out.print(egs1+" vs ");
            //System.out.println(egs2);

            Partido partidox = new Partido(equips1, equips2, egs1, egs2);

            //System.out.println("partido "+x+" "+equips1.getNombre()+" "+partidox.resultado(equips1));


            //////////////////////////////////////////////////////
            //   PRONOSTICOS

            String[] idpx = idpronosticos.get(x).split(",");

            Equipo equipoprons1 = new Equipo(idpx[1], "");
            Equipo equipoprons2 = new Equipo(idpx[5], "");

            //System.out.println(equipoprons1.getNombre()+" contra "+equipoprons2.getNombre());

            int egps1 = 0;
            int egps2 = 0;
            if (idpx[2] != "") {
                egps1 = 1;
                egps2 = 0;
            } else if (idpx[4] != "") {
                egps1 = 0;
                egps2 = 1;
            } else if (idpx[3] != "") {
                egps1 = 0;
                egps2 = 0;
            } else {
                System.out.println("falta dato en pronostico.csv del partido");
                if (egs1==egs2 ) {
                    egps1 = 30;
                }
            }

            Partido partidopronx = new Partido(equipoprons1,equipoprons2,egps1,egps2);

            Pronostico pronosticox = new Pronostico(partidox,equips1,partidopronx.resultado(equipoprons1));

            //System.out.println("puntos "+pronosticox.puntos());
            if (pronosticox.puntos() ==1) {
                System.out.println("asierto en el partido "+x+" entre "+equips1.getNombre()+" y "+equips2.getNombre()+" suma un punto.");
            }

            puntosJugador1 += pronosticox.puntos();

        }

        System.out.println("Total puntos jugador 1: "+puntosJugador1);

    }

}
