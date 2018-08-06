/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *
 * @author drohne
 */
public class PedidoVentas {
    private final int idOrden;
    //Declaracion del arreglo de productos
    private Producto productos[];
    private static int contadorOrdenes;
    private int contadorProductos = 0;
    //Definimos el maximo elementos del arreglo
    private static final int maxProductos = 10;

    public PedidoVentas() {
        this.idOrden = ++contadorOrdenes;
        //Se instancia el arreglo de productos
        productos = new Producto[maxProductos];
    }

    public void agregarProducto(Producto producto) {
        //Si los productos agregados no superan al máximo de productos
        //agregamos el nuevo producto
        if (contadorProductos < maxProductos) {
            //Agregamos el nuevo producto al arreglo
            //e incrementamos el contador de productos
            productos[contadorProductos] = producto;
            contadorProductos++;
        }
        else{
            System.out.println("Se ha superado el maximo de productos: " + maxProductos);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < contadorProductos; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    public void mostrarOrden() {
        System.out.println("Orden #:" + idOrden);
        System.out.println("Total de la orden #"+ idOrden + ": €" + calcularTotal());
        System.out.println("Productos de la orden #" + idOrden + ":");
        for (int i = 0; i < contadorProductos; i++) {
            System.out.println(productos[i]);
        }
    }
}
