package com.watabou.noosa.tweeners;

import com.watabou.noosa.Visual;
import com.watabou.utils.PointF;

public class ScaleTwinner extends Tweener {

	public Visual visual;
	
	public PointF start;
	public PointF end;
	
	public ScaleTwinner( Visual visual, PointF scale, float time ) {
		super( visual, time );
		
		this.visual = visual;
		start = visual.scale;
		end = scale;
	}

	@Override
	protected void updateValues( float progress ) {
		visual.scale = PointF.inter( start, end, progress );
	}
}
