/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Drugdu
 */
public class EspacioEscudo extends Espacio implements IOcupable{

    @Override
    public char getChar() {
        return ' ';
    }

    @Override
    public boolean isOcupado() {
        return jugador !=null;
    }

    @Override
    public void Ocupar(Jugador j) {
        this.jugador=j;
    }

    @Override
    public void Desocupar() {
        this.jugador=null;
    }
    
}
