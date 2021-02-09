import { Noticia } from './../utils/Noticia';
import { Injectable } from '@angular/core';
import { element } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class NoticiasService {

  noticias: Noticia[] = [
    {
      source: {
        id: '',
        name: 'BBC News',
      },
      category: 'sociedad',
      author: 'https://www.facebook.com/bbcnews',
      title: 'Crowd protests against military rule in Myanmar  BBC News',
      description:
        "Saturday's rally in Yangon is reportedly the biggest since the military seized power on Monday.",
      url: 'https://www.bbc.com/news/worldasia55960284',
      urlToImage:
        'https://ichef.bbci.co.uk/news/1024/branded_news/EB90/production/_116840306_reumyanmar.jpg',
      publishedAt: '20210206T04:57:00Z',
      content:
        'Hundreds of people have rallied in Myanmar\'s main city, Yangon, to protest against this week\'s military coup. \r\n"Military dictator, fail, fail; Democracy, win, win," chanted the crowd, the largest pr… [+5957 chars]',
    },
    {
      source: {
        id: 'politico',
        name: 'Politico',
      },
      category: 'politica',
      author: 'Josh Gerstein',
      title:
        'Supreme Court lifts California worship bans prompted by coronavirus  Politico',
      description:
        'The ruling issued just before 11 p.m. ET Friday produced four separate statements by the justices.',
      url:
        'https://www.politico.com/news/2021/02/05/scotuscaliforniaworshipbans466466',
      urlToImage: '',
      publishedAt: '20210206T04:50:00Z',
      content:
        'Perhaps the most surprising aspect of the Friday night ruling: new Justice Amy Coney Barrett, whose conservative Catholic views drew suspicion from many liberals in advance of her confirmation last y… [+2810 chars]',
    },
    {
      source: {
        id: 'nbcnews',
        name: 'NBC News',
      },
      category: 'sociedad',
      author: 'Dennis Romero, The Associated Press',
      title:
        'Kansas City Chiefs assistant coach expected to miss Super Bowl after crash that injured children  NBC News',
      description:
        'Kansas City Chiefs outside linebackers coach Britt Reid is expected to sit out the Super Bowl after being involved in multivehicle crash that injured two children.',
      url:
        'https://www.nbcnews.com/news/sports/kansascitychiefsassistantcoachexpectedmisssuperbowlaftern1256926',
      urlToImage: '',
      publishedAt: '20210206T04:47:00Z',
      content:
        'Kansas City Chiefs outside linebackers coach Britt Reid is expected to sit out the Super Bowl after he was involved in a multivehicle crash Thursday night in Missouri in which two children were inju… [+1703 chars]',
    },
    {
      source: {
        id: '',
        name: 'New York Post',
      },
      category: 'deporte',
      author: 'Ken Davidoff',
      title:
        'What Mets could spend on next after Trevor Bauer miss  New York Post ',
      description:
        'You ever have $105 million burning a hole in your pocket? Then you can relate to the Mets. OK, that represents a slight misconstruing of what went down Friday. What’s clear, however, is that Steve …',
      url:
        'https://nypost.com/2021/02/05/freeagentsmetscouldspendonnextaftertrevorbauermiss/',
      urlToImage: '',
      publishedAt: '20210206T04:22:00Z',
      content:
        'You ever have $105 million burning a hole in your pocket?\r\nThen you can relate to the Mets.\r\nOK, that represents a slight misconstruing of what went down Friday. Whats clear, however, is that Steve C… [+2288 chars]',
    },
    {
      source: {
        id: 'foxnews',
        name: 'Fox News',
      },
      category: 'deporte',
      author: 'Dom Calicchio',
      title:
        'With Kevin Durant forced to leave, Nets fall to Raptors 123117  Fox News',
      description:
        "It was a bizarre night in Brooklyn for the Nets on Friday  with superstar Kevin Durant initially kept out of the game, then allowed in, then ultimately removed in the third quarter because of the NBA's health and safety protocos.",
      url:
        'https://www.foxnews.com/sports/withkevindurantforcedtoleavenetsfalltoraptors123117',
      urlToImage:
        'https://static.foxnews.com/foxnews.com/content/uploads/2021/02/Durrant2.jpg',
      publishedAt: '20210206T04:20:48Z',
      content:
        'It was a bizarre night in Brooklyn for the Nets on Friday  with superstar Kevin Durant initially kept out of the game, then allowed in, then ultimately removed in the third quarter because of the N… [+2256 chars]',
    },
    {
      source: {
        id: '',
        name: "Investor's Business Daily",
      },
      category: 'politica',
      author: "Investor's Business Daily",
      title:
        "Dow Jones Futures: Congress Fast Tracks Biden Stimulus Plan; Apple, Disney Lead Five Actionable Dow Stocks  Investor's Business Daily",
      description:
        'Dow Jones futures: Congress has fast tracked the Biden stimulus plan. That helped fuel the stock market rally. Apple, Disney leads 5 actionable Dow stocks.',
      url:
        'https://www.investors.com/markettrend/stockmarkettoday/dowjonesfuturescongressfasttracksbidenstimulusplanappledisneystocks/',
      urlToImage: '',
      publishedAt: '20210206T03:37:00Z',
      content:
        'Dow Jones futures will open Sunday evening, along with S&amp;P 500 futures and Nasdaq futures. The House gave final approval Friday night to a budget resolution that paves the way for President Joe B… [+9380 chars]',
    },
    {
      source: {
        id: 'thehill',
        name: 'The Hill',
      },
      category: 'sociedad',
      author: 'Sarah Polus',
      title:
        "Iowa governor rolls back state's COVID19 restrictions | TheHill  The Hill",
      description:
        "Iowa Republican Gov. Kim Reynolds issued a new health proclamation Friday that relaxed many of the state's existing COVID19 regulations.",
      url:
        'https://thehill.com/homenews/statewatch/537639iowagovernorrollsbackstatescovid19restrictions',
      urlToImage:
        'https://thehill.com/sites/default/files/reynoldskim_10312020getty.jpg',
      publishedAt: '20210206T03:29:29Z',
      content:
        "Iowa Republican Gov. Kim Reynolds issued a new health proclamation Friday that relaxed many of the state's existing COVID19 regulations.\r\nAmong the policy reversals in the Public Health Disaster pro… [+2151 chars]",
    },
    {
      source: {
        id: '',
        name: 'Entertainment Tonight',
      },
      category: 'deporte',
      author: 'Liz Calvario‍',
      title:
        "Anna Nicole Smith's Daughter Dannielynn Birkhead Looks Just Like Her at 14 Years Old  Entertainment Tonight",
      description:
        "In a '20/20' special, Dannielynn travels with father Larry Birkhead to Anna Nicole’s Texas hometown and nostalgic locations in L.A.",
      url:
        'https://www.etonline.com/annanicolesmithsdaughterdannielynnbirkheadlooksjustlikeherat14yearsold160153',
      urlToImage: '',
      publishedAt: '20210206T03:07:00Z',
      content:
        "Anna Nicole Smith's daughter, Dannielynn Birkhead, is her mini me. The late model and her 14yearold teenager couldn't look more alike in a new 20/20 special, Tragic Beauty, that aired Friday.\r\nAhea… [+2051 chars]",
    },
    {
      source: {
        id: 'politico',
        name: 'Politico',
      },
      category: 'politica',
      author: 'David Siders',
      title: 'Sasse seizes a 2024 GOP lane that might not exist  POLITICO',
      description:
        'If the GOP’s fervor for Trump fades to any degree, Sasse will be better positioned than anyone to capitalize.',
      url: 'https://www.politico.com/news/2021/02/05/bensasse2024466424',
      urlToImage: '',
      publishedAt: '20210206T02:07:00Z',
      content:
        'His video ricocheted around the Republican universe on Thursday night and Friday not because it was critical of Trump as Sasse and other traditionalists have been before but because it so directly ch… [+6990 chars]',
    },
    {
      source: {
        id: '',
        name: 'New York Times',
      },
      category: 'politica',
      author: 'David E. Sanger',
      title:
        'Biden Bars Trump From Receiving Intelligence Briefings, Citing ‘Erratic Behavior’  The New York Times',
      description:
        'Mr. Biden said there was “no need” for former President Donald J. Trump to get the briefings, traditionally given to expresidents as a courtesy and to keep them informed if their advice is needed.',
      url:
        'https://www.nytimes.com/2021/02/05/us/politics/bidentrumpintelligencebriefings.html',
      urlToImage: '',
      publishedAt: '20210206T02:06:00Z',
      content:
        'The White House said this week that it had been reviewing whether the former president, whose impeachment trial in the Senate begins on Tuesday, should receive the briefings. The chairman of the Hous… [+1500 chars]',
    },
  ];

  noticiasFiltradas: Noticia[] = [];
 
  constructor() { }

  getAllNoticias(): Noticia[]{
    return this.noticias;
  }

  getNoticiasFiltradas(categoria: string): Noticia[]{

    // elemento es la noticia que itera
    this.noticiasFiltradas = this.noticias.filter((elemento)=>{ if(elemento.category == categoria){
      return elemento
    } });

    return this.noticiasFiltradas;
  }
}
