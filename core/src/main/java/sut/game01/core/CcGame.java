package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;

public class CcGame extends Game.Default {

  public CcGame() {
    super(33); // call update every 33ms (30 times per second)
  }
  private Image bgImage;
  private ImageLayer bgLayer;

  private Cloud c;
  private Cloud c2;
  private Cloud c3;

  @Override
  public void init() {
    // create and add background image layer
    bgImage = assets().getImage("images/bg.png");
    bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);

    c = new Cloud(0,0,5f);
    c2 = new Cloud(0,30,10f);
    c3 = new Cloud(0,50,7f);

    graphics().rootLayer().add(c.getObject());
    graphics().rootLayer().add(c2.getObject());
    graphics().rootLayer().add(c3.getObject());
  }

  @Override
  public void update(int delta) {
    c.update();
    c2.update();
    c3.update();
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
  
}

class Cloud
{
  private ImageLayer ml;
  private boolean mRight = true;
  private float x,y;
  private float speed;

  public Cloud(float x,float y,float speed)
  {
    Image cImage = assets().getImage("images/cc.png");
    ml = graphics().createImageLayer(cImage);

    this.x = x;
    this.y = y;
    this.speed = speed;
  }

  public void update()
  {
    if( mRight == true)
    {
      x += speed;

      if(x > 540)
      {
        mRight = false;
        x = 540;
      }
    }
    else
    {
      x -= speed;
      if ( x < 0)
      {
        mRight = true;
        x = 0;
      }
    }

    ml.setTranslation(x,y);
  }

  public ImageLayer getObject()
  {
    return ml;
  }

}
