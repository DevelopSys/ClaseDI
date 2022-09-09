import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagen'
})
export class ImagenPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    
    console.log(value);
    
    switch (value['strSport']) {
      case 'Soccer':
        return 'https://s1.1zoom.me/big0/219/Footbal_Men_Goalkeeper_(football)_Two_Ball_Glove_542575_1280x853.jpg';
        break;
      case 'Ice Hockey':
        return 'https://www.thoughtco.com/thmb/Mqsb5W_9rbBP96TJseMtO0Eo5SE=/3001x1688/smart/filters:no_upscale()/GettyImages-849841322-9921727d388148d1a8c1dc9146a1aa9f.jpg';
        break;
      case 'Baseball':
        return 'https://images-na.ssl-images-amazon.com/images/G/01/digital/video/hero/TVSeries/BaseballAFilmByKenBurns_3919300-BASE._V392937836_SX1080_.jpg';
        break;
      case 'Basketball':
        return 'https://www.nba.com/images/cms/2019-08/basketball-rack-ahs.jpg?w=1920&h=1080';
        break;
    
      default:
        return null;

    }

  }

}
