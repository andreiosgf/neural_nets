/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.afloriano.perceptron_updated;

/**
 *
 * @author andre
 */
public class Perceptron_Updated {

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
    
    public static double sigmoid(double x)
    {
        return (1/(1+Math.exp(-x)));
    }
    
    public static double d_sigmoid(double x)
    {
        return(sigmoid(x)*(1-sigmoid(x)));
    }
    
    public static double delta_gen(double e,double x){
        return d_sigmoid(x)*e;
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
    
    public static double update(double w,double e,int x,double v,double alpha)
    {
        double delta=delta_gen(e,v);
        double new_w=w+alpha*delta*x;
        return new_w;
    }
    
    public static void full_process()
    {
        int[][] x=new int[4][3];
        double[] d=new double[4];
        double[] w=new double[3];
        double alpha=0.15;
        
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
        
       /* w[0]=1.0;
        w[1]=0.0;
        w[2]=-0.5;*/
        
        w[0]=Math.random();
        w[1]=Math.random();
        w[2]=Math.random();
        double y=0;
        double full_error=0.0;
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
                double v=sumatoria(x[i],w);
                //y=Heaviside(sumatoria(x[i],w));
                y=sigmoid(v);
                System.out.println("Activación = "+y);
                error=d[i]-y;
                System.out.println("Error "+error);
                if(error!=0)
                {
                    System.out.println("Updating weights");
                    //full_error+=Math.abs(error);
                    full_error+=Math.pow(d[i]-y, 2);
                    for(int j=0;j<w.length;j++)
                    {            
                        //update(double w,double e,int x,double v,double alpha)
                        w[j]=update(w[j],error,x[i][j],v,alpha);
                        
                    }
                }
            }
            System.out.println("Pesos finales de la época");
        printArray(w);
        full_error=0.5*full_error;
        System.out.println("Error total "+full_error);
        
        if(full_error<0.01)
        {
            break;
        }
            
            epocas++;
        }
       
    }
    
    public static void main(String[] args) {
        System.out.println("Updated Perceptron");
        full_process();
    }
}
