/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.afloriano.perceptron;

/**
 *
 * @author andre
 */
public class Perceptron {

    public static void printArray(double[] w)
    {
        for(int i=0;i<w.length;i++)
        {
            System.out.println("w["+i+"]= "+w[i]);
        }
    }
    
    public static void printArray(int[] w)
    {
        for(int i=0;i<w.length;i++)
        {
            System.out.println("x["+i+"]= "+w[i]);
        }
    }
    
    public static int Heaviside(double x)
    {
        if(x<0)
            return 0;
        else
            return 1;
    }
    
    public static double sumatoria(int[] x,double[] w)
    {
        double suma=0.0;
            for(int i=0;i<x.length;i++)
            {
                suma+=x[i]*w[i];
            }
        return suma;
    }
    
    public static double update(double w,double e,int x,double alpha)
    {
        double new_w=w+alpha*e*x;
        return new_w;
    }
    
    public static void full_process()
    {
        int[][] x=new int[4][3];
        double[] d=new double[4];
        double[] w=new double[3];
        double alpha=0.1;
        
        x[0][0]=0;
        x[0][1]=0;
        x[0][2]=1;
        
        x[1][0]=0;
        x[1][1]=1;
        x[1][2]=1;
        
        x[2][0]=1;
        x[2][1]=0;
        x[2][2]=1;
        
        x[3][0]=1;
        x[3][1]=1;
        x[3][2]=1;
        
        d[0]=0;
        d[1]=0;
        d[2]=0;
        d[3]=1;
        
        w[0]=1.0;
        w[1]=0.0;
        w[2]=-0.5;
        
        double y=0;
        int full_error=0;
        int epocas=0;
        double error=0;
        while(epocas<100000)
        {
            full_error=0;
            System.out.println("**********************INIT EPOCH "+epocas+" ***********************");
            for(int i=0;i<x.length;i++){
                
                System.out.println("Patrón "+i);
                printArray(x[i]);
                System.out.println("");
                printArray(w);
                y=Heaviside(sumatoria(x[i],w));
                System.out.println("Sumatoria = "+y);
                error=d[i]-y;
                System.out.println("Error "+error);
                if(error!=0)
                {
                    System.out.println("Updating weights");
                    full_error++;
                    for(int j=0;j<w.length;j++)
                    {                        
                        w[j]=update(w[j],error,x[i][j],alpha);
                        
                    }
                }
            }
            System.out.println("Pesos finales de la época");
        printArray(w);
        System.out.println("Errores totales "+full_error);
        
        if(full_error==0)
        {
            break;
        }
            
            epocas++;
        }
       
    }
    public static void main(String[] args) {
        System.out.println("Simpe Perceptron");
        full_process();
    }
}
