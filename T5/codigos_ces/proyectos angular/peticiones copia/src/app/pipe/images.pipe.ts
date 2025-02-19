import { Pipe, PipeTransform } from '@angular/core';
import { Post } from '../model/modelos';

@Pipe({
  name: 'images',
  standalone: false,
})
export class ImagesPipe implements PipeTransform {
  transform(value: Post, ...args: unknown[]): string {
    if (value.tags.includes('history')) {
      return 'https://static01.nyt.com/images/2016/07/10/books/review/10McGirr/10McGirr-videoSixteenByNineJumbo1600.jpg?year=2016&h=900&w=1600&s=1606788b210239c14dc1d07b84ebe94f2858791f39636a7348a8e5ae86750aa9&k=ZQJBKqZ0VN&tw=1';
    } else if (value.tags.includes('mystery')) {
      return 'https://static0.gamerantimages.com/wordpress/wp-content/uploads/2023/10/red-dead-redemption-2-manzanita-post.jpg';
    } else if (value.tags.includes('fiction')) {
      return 'https://lab.cccb.org/wp-content/uploads/postficcio_1.jpg';
    }

    return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0SsZ22SuwDnSdeEEIYrSoc9xCqh2Yp-22pA&s';
  }
}
