import { Injectable } from '@angular/core';
import { Ingrediente, Pedido, Pizza } from '../model/Clases';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private ingredientes: Ingrediente[] = [
    new Ingrediente('Tomate', 0.5),
    new Ingrediente('Mozzarella', 1.2),
    new Ingrediente('Albahaca', 0.3),
    new Ingrediente('Aceite de oliva', 0.4),
    new Ingrediente('Carne de res', 4.0),
    new Ingrediente('Lechuga', 0.5),
    new Ingrediente('Queso cheddar', 1.0),
    new Ingrediente('Pan de hamburguesa', 0.8),
    new Ingrediente('Tortilla de maíz', 0.5),
    new Ingrediente('Carnitas', 3.0),
    new Ingrediente('Cilantro', 0.2),
    new Ingrediente('Cebolla', 0.3),
    new Ingrediente('Salsa verde', 0.8),
    new Ingrediente('Pechuga de pollo', 2.5),
    new Ingrediente('Aguacate', 1.0),
    new Ingrediente('Jamon Serrano', 2.0),
    new Ingrediente('Manteca de cerdo', 1.5),
    new Ingrediente('Queso azul', 1.8),
    new Ingrediente('Pimientos', 0.8),
    new Ingrediente('Champiñones', 1.0),
    new Ingrediente('Cebollines', 0.6),
    new Ingrediente('Almejas', 3.0),
    new Ingrediente('Chistorra', 1.6),
  ];
  private pizzas: Pizza[] = [
    new Pizza(
      'Pizza Margherita',
      8.99,
      [
        new Ingrediente('Tomate', 0.5),
        new Ingrediente('Mozzarella', 1.2),
        new Ingrediente('Albahaca', 0.3),
        new Ingrediente('Aceite de oliva', 0.4),
      ],
      'https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pizza-margarita-1080x671.jpg'
    ),
    new Pizza(
      'Hamburguesa Clásica',
      10.5,
      [
        new Ingrediente('Carne de res', 4.0),
        new Ingrediente('Lechuga', 0.5),
        new Ingrediente('Tomate', 0.5),
        new Ingrediente('Queso cheddar', 1.0),
        new Ingrediente('Pan de hamburguesa', 0.8),
      ],
      'https://imag.bonviveur.com/hamburguesa-clasica.jpg'
    ),
    new Pizza(
      'Ensalada César',
      7.25,
      [
        new Ingrediente('Lechuga romana', 1.0),
        new Ingrediente('Crutones', 0.7),
        new Ingrediente('Pollo', 2.5),
        new Ingrediente('Queso parmesano', 1.2),
        new Ingrediente('Tomate', 0.5),
      ],
      'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/b876d8ea-fc9b-4b04-9958-9c70fe1c74e0/Derivates/fb3399fa-df15-4d0d-9beb-83a79a37a16e.jpg'
    ),
    new Pizza(
      'Sushi Roll de Salmón',
      12.99,
      [
        new Ingrediente('Arroz', 0.8),
        new Ingrediente('Salmón', 4.5),
        new Ingrediente('Aguacate', 1.0),
        new Ingrediente('Alga nori', 0.6),
        new Ingrediente('Sésamo', 0.4),
      ],
      'https://www.oliveradatenea.com/wp-content/uploads/2023/06/Sushi-rolls-de-salmon-y-Olivada-Olivera-dAtenea.jpg'
    ),
    new Pizza(
      'Tacos de Carnitas',
      9.0,
      [
        new Ingrediente('Tortilla de maíz', 0.5),
        new Ingrediente('Carnitas', 3.0),
        new Ingrediente('Cilantro', 0.2),
        new Ingrediente('Cebolla', 0.3),
        new Ingrediente('Salsa verde', 0.8),
      ],
      'https://okdiario.com/img/2022/04/30/tacos.jpg'
    ),
    new Pizza(
      'Pasta Carbonara',
      11.5,
      [
        new Ingrediente('Espagueti', 1.5),
        new Ingrediente('Huevo', 0.7),
        new Ingrediente('Panceta', 3.0),
        new Ingrediente('Queso parmesano', 1.8),
        new Ingrediente('Tomate', 0.5),
      ],
      'https://images.unsplash.com/photo-1603133872876-8939dc73c56d'
    ),
    new Pizza(
      'Ramen Tradicional',
      13.75,
      [
        new Ingrediente('Fideos de ramen', 1.2),
        new Ingrediente('Caldo de cerdo', 3.5),
        new Ingrediente('Huevo cocido', 0.7),
        new Ingrediente('Cebollín', 0.4),
        new Ingrediente('Cilantro', 0.2),
      ],
      'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_yXz3q6Pvc2Rw1mHWBtL0WDIyUM9vtElXgA&s'
    ),
    new Pizza(
      'Ceviche de Pescado',
      14.2,
      [
        new Ingrediente('Pescado blanco', 5.0),
        new Ingrediente('Jugo de limón', 0.8),
        new Ingrediente('Cilantro', 0.2),
        new Ingrediente('Cebolla roja', 0.5),
        new Ingrediente('Sésamo', 0.4),
      ],
      'https://i.ytimg.com/vi/_ivdbk8kzMg/maxresdefault.jpg'
    ),
    new Pizza(
      'Burrito de Pollo',
      9.95,
      [
        new Ingrediente('Tortilla de harina', 0.7),
        new Ingrediente('Pollo asado', 3.0),
        new Ingrediente('Frijoles', 0.8),
        new Ingrediente('Arroz', 0.7),
        new Ingrediente('Salsa verde', 0.8),
      ],
      'https://campollo.com/wp-content/uploads/2023/06/burritos-de-pollo-y-vegetales.jpg'
    ),
    new Pizza(
      'Helado de Vainilla',
      4.5,
      [
        new Ingrediente('Leche', 1.2),
        new Ingrediente('Crema', 1.5),
        new Ingrediente('Azúcar', 0.5),
        new Ingrediente('Vainilla', 0.8),
      ],
      'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaeqsusG-IRgyfbLVsah4N9FfOi-MM0HucJA&s'
    ),
  ];
  private pedidos: Pedido[] = [];

  constructor() {}

  getIngredientes(): Ingrediente[] {
    return this.ingredientes;
  }

  getPizzas(): Pizza[] {
    return this.pizzas;
  }

  getAllPedidios(): Pedido[] {
    return this.pedidos;
  }

  addPedido(pedido: Pedido) {
    this.pedidos.push(pedido);
  }
}
