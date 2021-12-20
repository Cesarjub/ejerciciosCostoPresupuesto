package Presupuestos;

//Cesar Julio Beltran - Costos y Presupuestos

public class GetOperaciones 
{
    GetOperaciones()
    {}
    
    public float getMargenSobreVentas(float pe, float porc, float tMC)
    {
        float temp = 0.0f, temp2 = 0.0f;
        
        temp = porc / 100;
        
        temp2 = tMC / 100;
        
        return (pe * temp) / temp2;
    }
    
    public float getEquilibrioUnidad(float cf, float cv, float prec)
    {
        return (cf /(prec - cv));
    }
    
    public float getMargenContribucion(float prec, float cv)
    {
        return (float) ((prec - cv) / prec) * 100;
    }
    
    public float getEquilibrioPeso(float cf, float mc)
    {
        float temp = 0.0f;
        
        temp = mc / 100;
        
        return (cf / temp);
    }
    
    public int getUtilidadDespuesImpuestos(float cf, float ud, float tasa, float mc)
    {
        float temp = 0.0f, temp2 = 0.0f;
        
        temp = tasa / 100;
        
        temp2 = mc / 100;
        
        return (int) ((cf + ud /(1 - temp)) / temp2);
    }  
    
    public float getCostoVariable(float prc, float porc, float gtoVta)
    {
        float temp = 0.0f;
        
        temp = porc / 100;
        
        return (float) (((prc + temp) +gtoVta) + 2.85);
    }
    
    public float getMargenContribucionActual(float cv, float prc)
    {
        return (cv / 60) * prc;
    }
    
    public float getNuevoPrecio(float cv, float mc)
    {
        return cv + mc;        
    }
}
