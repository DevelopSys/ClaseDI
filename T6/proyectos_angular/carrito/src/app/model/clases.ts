export interface Producto {
  nombre: string;
  precio: number;
  categoria: string;
  valor_energetico: number;
}

export interface Pedido {
  id: number;
  nombre: string;
  productos: Producto[];
  precio: number;
}
