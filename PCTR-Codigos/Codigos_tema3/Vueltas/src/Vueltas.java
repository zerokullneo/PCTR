/**
 * Copyright (C) 2015 Jose Manuel Barba Gonzalez <zk at wordpress.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**Fichero Vueltas.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Vueltas extends Thread
{
   private boolean hY;
   private int     v;
   
   public Vueltas(boolean hacerYield, int vueltas) 
   {hY = hacerYield; v = vueltas;}
   
   public void run()
   {
   	for(int i=0; i<v; i++)
     if(i==20&&hY==true)
      {this.yield();}
   	 else System.out.println("Hilo "+this.getName()+" en iteracion "+i);
   }
    
    public static void main(String[] args) 
    {
       Vueltas h0 = new Vueltas(false, 50);
       Vueltas h1 = new Vueltas(false, 50);
       Vueltas h2 = new Vueltas(true , 50); //este hilo indica al planificador que cede prioridad
       h0.setName("1-NoYield");                      //y este lo considerara o no...
       h1.setName("2-NoYield");
       h2.setName("3-SIYield");
       h0.start();
       h1.start();
       h2.start();
    }


}
