package Rendering;

import Math.PVector;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {
	private static float rFill, gFill, bFill;
	private static float rStroke, gStroke, bStroke;
	private static boolean fillEnable = true, strokeEnable = true;
	private static float rFilter = 1, gFilter = 1, bFilter = 1;
	private static PVector rotationCenter = new PVector(0, 0);
	private static float rotationAngle;

	public static void fill(float red, float green, float blue) {
		rFill = red / 255;
		gFill = green / 255;
		bFill = blue / 255;
		fillEnable = true;
	}

	public static void fill(Color color) {
		fill(color.getRed(), color.getGreen(), color.getBlue());
	}

	public static void noFill() {
		fillEnable = false;
	}

	public static void stroke(float red, float green, float blue) {
		rStroke = red / 255;
		gStroke = green / 255;
		bStroke = blue / 255;
		strokeEnable = true;
	}

	public static void stroke(Color color) {
		stroke(color.getRed(), color.getGreen(), color.getBlue());
	}

	public static void noStroke() {
		strokeEnable = false;
	}

	public static void strokeWidth(float widht) {
		GL2 gl = EventListener.gl;
		gl.glLineWidth(widht);
	}

	public static void line(float startX, float startY, float endX, float endY) {
		GL2 gl = EventListener.gl;
		gl.glColor3f(rStroke * rFilter, gStroke * gFilter, bStroke * bFilter);
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(startX, startY);
		gl.glVertex2f(endX, endY);
		gl.glEnd();
	}

	public static void rect(float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		if (fillEnable) {
			gl.glColor3f(rFill * rFilter, gFill * gFilter, bFill * bFilter);
			gl.glBegin(GL2.GL_QUADS);
			rectShell(gl, x, y, width, height);
			gl.glEnd();
		}
		if (strokeEnable) {
			gl.glColor3f(rStroke * rFilter, gStroke * gFilter, bStroke * bFilter);
			gl.glBegin(GL2.GL_LINE_LOOP);
			rectShell(gl, x, y, width, height);
			gl.glEnd();
		}
	}

	private static void rectShell(GL2 gl, float centerX, float centerY, float width, float height) {
		float cornerX = centerX - width / 2;
		float cornerY = centerY - height / 2;
		rotatedVertex(gl, cornerX, cornerY);
		rotatedVertex(gl, cornerX, cornerY + height);
		rotatedVertex(gl, cornerX + width, cornerY + height);
		rotatedVertex(gl, cornerX + width, cornerY);
	}

	private static void rotatedVertex(GL2 gl, float x, float y) {
		float vectorX = x - rotationCenter.x;
		float vectorY = y - rotationCenter.y;
		float rotatedX = (float) (vectorX * Math.cos(rotationAngle) - vectorY * Math.sin(rotationAngle))
				+ rotationCenter.x;
		float rotatedY = (float) (vectorY * Math.cos(rotationAngle) + vectorX * Math.sin(rotationAngle))
				+ rotationCenter.y;
		gl.glVertex2f(rotatedX, rotatedY);
	}

	public static void ellipse(float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		if (fillEnable) {
			gl.glColor3f(rFill * rFilter, gFill * gFilter, bFill * bFilter);
			gl.glBegin(GL2.GL_POLYGON);
			ellipseShell(gl, x, y, width, height);
			gl.glEnd();
		}
		if (strokeEnable) {
			gl.glColor3f(rStroke * rFilter, gStroke * gFilter, bStroke * bFilter);
			gl.glBegin(GL2.GL_LINE_LOOP);
			ellipseShell(gl, x, y, width, height);
			gl.glEnd();
		}
	}

	private static void ellipseShell(GL2 gl, float x, float y, float width, float height) {
		for (int i = 0; i < 360; i += 2) {
			double rad = 2 * Math.PI * i / 360;
			float radiusX = (float) width / 2;
			float radiusY = (float) height / 2;
			rotatedVertex(gl, x + (float) Math.cos(rad) * radiusX, y + (float) Math.sin(rad) * radiusY);
		}
	}

	public static void image(ImageResource image, float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		Texture tex = image.getTexture();
		if (tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		gl.glColor3f(rFill * rFilter, gFill * gFilter, bFill * bFilter);
		gl.glBegin(GL2.GL_QUADS);
			float cornerX = x - width / 2;
			float cornerY = y - height / 2;
			gl.glTexCoord2f(0, 0);
			rotatedVertex(gl, cornerX, cornerY);
			gl.glTexCoord2f(0, 1);
			rotatedVertex(gl, cornerX, cornerY + height);
			gl.glTexCoord2f(1, 1);
			rotatedVertex(gl, cornerX + width, cornerY + height);
			gl.glTexCoord2f(1, 0);
			rotatedVertex(gl, cornerX + width, cornerY);
		gl.glEnd();
		
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
	}

	public static void rotate(float centerX, float centerY, float angle) {
		rotationCenter = new PVector(centerX, centerY);
		rotationAngle = angle;
	}

	public static void endRotate() {
		rotationAngle = 0;
	}

	public static void setColorFilter(float red, float green, float blue) {
		rFilter = Math.max(0, Math.min(red, 1));
		gFilter = Math.max(0, Math.min(green, 1));
		bFilter = Math.max(0, Math.min(blue, 1));
	}

	public static float getRedFilter() {
		return rFilter;
	}

	public static float getGreenFilter() {
		return gFilter;
	}

	public static float getBlueFilter() {
		return bFilter;
	}

	public static void switchRedFilter() {
		rFilter = 1 - rFilter;
	}

	public static void switchGreenFilter() {
		gFilter = 1 - gFilter;
	}

	public static void switchBlueFilter() {
		bFilter = 1 - bFilter;
	}
}
