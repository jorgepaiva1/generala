/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class Generala {
    int[] dados= new int[5];
    int jugada;
    
    public Generala(){
        for(int k=0;k<5;k++)
            dados[k]= (int)(Math.random()*((6-1)+1))+1; //((max-min)+1)+min
        jugada=0;
        
    }
    
    public int generala(){
        int correcto=1;
        
            for(int k=1;k<5;k++){
                if(dados[k]!=dados[k-1]){
                    correcto=0;
                    break;
                }
            }
        if(correcto==1)    
            return 1;
        else
            return 0;
    }
    
    public int Poker(){
        int poker=1;
        int correcto=1;
        
        finpoker:
        for(int k=0;k<2;k++){
            for(int i=0;i<5;i++){
                if(dados[k]==dados[i]&&k!=i){
                    poker++;
                    if(poker==4){
                        poker=1;
                        correcto=2;
                        continue finpoker;
                    }
                }
            }
            poker=1;
        }
        if(correcto==2)
            return 2;
        else
            return 0;
        
    }
    
    public void ordenar(){
        int auxord;
        
        for(int k=0;k<5;k++){
            for(int i=0;i<5;i++){
                if(dados[k]<dados[i]){
                    auxord=dados[i];
                    dados[i]=dados[k];
                    dados[k]=auxord;
                }
            }
        }
        
    }
    
    public int Full(){
        int correcto=1;
        ordenar();
        
        if(dados[0]==dados[1]&& dados[0]==dados[2]&&dados[3]==dados[4])
            correcto=3;
        if(dados[0]==dados[1]&&dados[2]==dados[3]&&dados[2]==dados[4])
            correcto=3;
            
        if(correcto==3)
            return 3;
        else
            return 0;
    }
    
    public int Escalera(){
        ordenar();
        int correcto=1;
        
        for(int k=1;k<5;k++)
            if(dados[k]<=dados[k-1]){
                return 0;
            }
        
        return 4;
    }
    
    
    public String toString(){
        ordenar();
        return ("El dado tiene estos valores: "+String.valueOf(dados[0])+","+String.valueOf(dados[1])+","+String.valueOf(dados[2])
                +","+String.valueOf(dados[3])+","+String.valueOf(dados[4]));
    }
            
    public static void main (String[] args){
        Generala jugada=new Generala();
        
        System.out.println(jugada.toString());
        
        int resultado,resultadogral=0;
        resultado=jugada.generala();
        if(resultado!=0){
            System.out.println("Los dados generaron un GENERALA!!");
            resultadogral++;
        } 
        
        resultado=jugada.Poker();
        if(resultado!=0){
            System.out.println("Los dados generaron un Poker!!");
            resultadogral++;
        }
        
        resultado=jugada.Full();
        if(resultado!=0){
            System.out.println("Los dados generaron un Full!!!");
            resultadogral++;
        } 
        resultado=jugada.Escalera();
        if(resultado!=0){
            System.out.println("Los dados generaron una Escalera!!");
            resultadogral++;
        }
        if(resultadogral==0)
            System.out.println("Los dados no generaron nada :(  ");
    }
}
