package org.janelia.saalfeldlab.n5.transforms;

import net.imglib2.realtransform.AffineGet;

public interface LinearSpatialTransform extends SpatialTransform {

	@Override
	public AffineGet getTransform();
}
