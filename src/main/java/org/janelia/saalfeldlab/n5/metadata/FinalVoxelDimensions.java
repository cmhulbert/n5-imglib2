/**
 * Copyright (c) 2018--2020, Saalfeld lab
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.janelia.saalfeldlab.n5.metadata;

public class FinalVoxelDimensions
{
	private final String unit;

	private final double[] dimensions;

	public FinalVoxelDimensions( final String unit, final double... dimensions )
	{
		this.unit = unit;
		this.dimensions = dimensions.clone();
	}

	public int numDimensions()
	{
		return dimensions.length;
	}

	public String unit()
	{
		return unit;
	}

	public void dimensions( final double[] dims )
	{
		for ( int d = 0; d < dims.length; ++d )
			dims[ d ] = this.dimensions[ d ];
	}

	public double dimension( final int d )
	{
		return dimensions[ d ];
	}

	public static boolean equals( FinalVoxelDimensions a, FinalVoxelDimensions b )
	{
		if( !a.unit().equals(b.unit()))
			return false;

		final double eps = 1e-9;
		for( int i = 0; i < a.numDimensions(); i++ ) {
			if (Math.abs( a.dimension(i) - b.dimension(i)) > eps)
				return false;
		}

		return true;
	}
}
