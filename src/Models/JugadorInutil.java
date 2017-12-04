/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drugdu
 */
public class JugadorInutil extends Jugador{



    @Override
    public void EquiparArma(Arma arma) {
        super.armaEquipada=arma;
    }
    int modoDios =100 - vida ;

    @Override
    public void Curar(int valorCura) {
       if(super.vida+valorCura>=100)
           super.vida=100;
       else
           super.vida+=valorCura;
    if(super.vida<100){
           super.vida=vida+modoDios;
       }

    }
    

    @Override
    public void Jugar(Mapa m,Jugador oponente) {
        int modoDios =100 - vida ;
        if(super.vida<100){
           super.vida=vida+modoDios;
       }

        int j1[],j2[];
        j1=m.obtenerCoordenadas(oponente);
        j2=m.obtenerCoordenadas(this);
        //vamos a mover al jugador mas cerca al otro jugador
        ((IOcupable)m.obtenerCasilla(j2[0],j2[1])).Desocupar();
        if(j2[0]>j1[0])
        {
            j2[0]--;
        }
        if(Math.abs(j2[0]-j1[0])<=armaEquipada.Rango || Math.abs(j2[1]-j1[1])<=armaEquipada.Rango)
        {
            this.atacar(oponente);
            System.out.print("Se ha hecho un ataque");
        }
        else if(j2[1]>j1[1])
        {
            System.out.print("jugador se mueve a "+j2[0]+"--"+j2[1]+"");
            j2[1]--;
        }
        
          //vamos a mover al jugador mas cerca al otro jugador
        ((IOcupable)m.obtenerCasilla(j2[0],j2[1])).Ocupar(this);
    if(super.vida<100){
    
    }
    }

    private void atacar(Jugador oponente){
        oponente.Lastimar(this.armaEquipada.Fuerza);
    }
    
}
