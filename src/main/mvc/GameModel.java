package main.mvc;

import main.prefabs.*;
import main.util.*;
import main.util.Rectangle;

import java.awt.*;
import java.util.ArrayList;

class GameModel {
	
	Player player;
	Ground ground;
	Camera camera;
	ArrayList<Obstacle> obstacles;
	CollisionState2D dynCol;
	
	
	private final double G = 20;
	private int deltaTime = 16; //ms
	
	GameModel(int width, int height) {
//		int[] xpoints = {width / 3, width / 3 + 15, width / 3 + 30};
//		int[] ypoints = {height / 2 + 30, height / 2, height / 2 + 30};
//		Polygon p = new Polygon(xpoints, ypoints, 3);
//		player = new Player(new BoxCollider(new Vector(width / 3, height / 2), 30, 30), new Vector(0, 0), p, Color.BLACK, new Vector(0.75, 0.75));
		player = PlayerFactory.standardSquarePlayer(width / 3, height / 2, 30, new Vector(2, 2));
		camera = new Camera(new Rectangle(0, 0, width, height));
		ground = new Ground(new BoxCollider(ShapeFactory.rectangle(3, 1, width - 7, height * 2 / 3)), Vector.zero(), PolygonFactory.rectangle(0, 0, width, height), Color.BLACK);
		obstacles = new ArrayList<>();
		int obstacleSide = 30;
		
		// 1 figure
		ArrayList<Obstacle> figure1 = new ArrayList<>();
		// 1 row
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 30, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 60, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 120, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		// 2 row
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 30, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 60, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 120, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		// 3 row
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 60, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 120, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 150, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 180, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 210, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		// 4 row
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 90, obstacleSide));
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 120, (int) ground.getCollider().getBottom() - obstacleSide - 90, obstacleSide));
		// 5 row
		figure1.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 120, (int) ground.getCollider().getBottom() - obstacleSide - 120, obstacleSide));
		
		// 2 figure
		ArrayList<Obstacle> figure2 = new ArrayList<>();
		// 1 row
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 30, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 60, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		
		// 2 row
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		
		// 3 row
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure2.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		
		// 3 figure
		ArrayList<Obstacle> figure3 = new ArrayList<>();
		// 1 row
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide, obstacleSide));
		
		// 2 row
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 30, obstacleSide));
		
		// 3 row
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 30, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 60, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		figure3.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6 + 90, (int) ground.getCollider().getBottom() - obstacleSide - 60, obstacleSide));
		
		ArrayList<Obstacle> cube = new ArrayList<>();
		cube.add(ObstacleFactory.staticCyanRectangleObstacle(width / 6, (int) ground.getCollider().getBottom() - obstacleSide - 150, obstacleSide));
		
		//Dynamic figure
		ArrayList<Obstacle> dynFigure = new ArrayList<>();
		int shiftY = -0;
		dynFigure.add(ObstacleFactory.dynamicRectangleObstacle(0, (int) ground.getCollider().getBottom() - obstacleSide + shiftY, obstacleSide, 100));
		dynFigure.add(ObstacleFactory.dynamicRectangleObstacle(30, (int) ground.getCollider().getBottom() - obstacleSide + shiftY, obstacleSide, 100));
		dynFigure.add(ObstacleFactory.dynamicRectangleObstacle(60, (int) ground.getCollider().getBottom() - obstacleSide + shiftY, obstacleSide, 100));
		dynFigure.add(ObstacleFactory.dynamicRectangleObstacle(90, (int) ground.getCollider().getBottom() - obstacleSide + shiftY, obstacleSide, 100));
		dynFigure.add(ObstacleFactory.dynamicRectangleObstacle(0, (int) ground.getCollider().getBottom() - obstacleSide - 30 + shiftY, obstacleSide, 100));
		dynFigure.add(ObstacleFactory.dynamicRectangleObstacle(90, (int) ground.getCollider().getBottom() - obstacleSide - 30 + shiftY, obstacleSide, 100));
		
		obstacles.addAll(dynFigure);
		obstacles.addAll(FigureShifter.shiftX(figure1, 250));
//		obstacles.addAll(FigureShifter.shiftX(figure2, 600));
//		obstacles.addAll(FigureShifter.shiftX(figure2, 800));
//		obstacles.addAll(FigureShifter.shiftX(figure3, 1000));
//		obstacles.addAll(FigureShifter.shiftX(figure3, 1200));
//		obstacles.addAll(FigureShifter.shiftX(cube, 500));
//		obstacles.addAll(FigureShifter.shiftX(cube, 630));
//		obstacles.addAll(FigureShifter.shiftX(cube, 760));
//		obstacles.addAll(FigureShifter.shiftX(cube, 890));
//		obstacles.addAll(FigureShifter.shiftX(cube, 1020));
//		obstacles.addAll(FigureShifter.shiftX(cube, 1150));
//		obstacles.addAll(FigureShifter.shiftX(cube, 1280));
	}
	
	void moveRight(boolean move) {
		player.moveRight(move);
//		checkPlayer();
	}
	
	void moveLeft(boolean move) {
		player.moveLeft(move);
//		checkPlayer();
	}
	
	void moveUp(boolean move) {
		player.moveUp(move);
//		checkPlayer();
	}
	
	void moveDown(boolean move) {
		player.moveDown(move);
//		checkPlayer();
	}
	
	
	private void checkObstacles() {
		for (Obstacle obstacle : obstacles) {
			checkObject(obstacle);
		}
	}
	
	private void checkPlayer() {
		checkObject(player);
	}
	
	private Vector getAvailableShift(CollidableGameObject toCollide, CollidableGameObject collideWith) {
		boolean insideType = (collideWith instanceof Ground);
		CollisionState2D colState = insideType ? collideWith.doesCollide(toCollide) : toCollide.doesCollide(collideWith);
		Vector maxNewPos = toCollide.getPosition().copyOf();
		if (colState.getX() != CollisionState.NONE) {
			if (colState.getX() == CollisionState.RIGHT) {
				if (insideType) {
					maxNewPos.setX(collideWith.getCollider().getRight() - toCollide.getCollider().getWidth());
				} else {
					maxNewPos.setX(collideWith.getCollider().getLeft() - toCollide.getCollider().getWidth() + collideWith.getSpeed().getX());
				}
			} else {
				if (insideType) {
					maxNewPos.setX(collideWith.getCollider().getLeft());
				} else {
					maxNewPos.setX(collideWith.getCollider().getRight() + collideWith.getSpeed().getX());
				}
			}
		} else {
//			maxNewPos.setX(maxNewPos.getX() + toCollide.getSpeed().getX());
			maxNewPos.setX(Integer.MAX_VALUE / 2.0 + 5);
		}
		
		if (colState.getY() != CollisionState.NONE) {
			if (colState.getY() == CollisionState.BOTTOM) {
				if (insideType) {
					System.out.println(1);
					maxNewPos.setY(collideWith.getCollider().getBottom() - toCollide.getCollider().getHeight());
				} else {
					maxNewPos.setY(collideWith.getCollider().getTop() - toCollide.getCollider().getHeight() + collideWith.getSpeed().getY());
				}
				if (toCollide instanceof Player) {
					((Player) toCollide).setAirborne(false);
					((Player) toCollide).hitBottom(collideWith);
				} else {
					toCollide.makeYSpeedZero();
				}
			} else {
				if (insideType) {
					maxNewPos.setY(collideWith.getCollider().getTop());
				} else {
					maxNewPos.setY(collideWith.getCollider().getBottom() + collideWith.getSpeed().getY());
				}
				if (toCollide instanceof Player) {
					((Player) toCollide).hitTop(G, deltaTime);
				} else {
					toCollide.makeYSpeedZero();
				}
			}
		} else {
			if (toCollide instanceof Player) {
				((Player) toCollide).setAirborne(false);
			}
//			maxNewPos.setY(maxNewPos.getY() + toCollide.getSpeed().getY());
			maxNewPos.setY(Integer.MAX_VALUE / 2.0 + 5);
		}
		return new Vector(maxNewPos.getX() - toCollide.getPosition().getX(),
				maxNewPos.getY() - toCollide.getPosition().getY());
	}
	
	private void checkObject(CollidableGameObject gameObject) {
		if (gameObject instanceof Player) {
			player.applyG(G, deltaTime);
			Vector maxShift = getAvailableShift(gameObject, ground); // max ground shift
			for (Obstacle obstacle : obstacles) {
				if (!camera.isInView(obstacle.getCollider().getRectangle())) {
					continue; // skip out of view objects
				}
				Vector curMaxShift = getAvailableShift(gameObject, obstacle);
				if (Math.abs(maxShift.getX()) > Math.abs(curMaxShift.getX())) {
					maxShift.setX(curMaxShift.getX());
				}
				if (Math.abs(maxShift.getY()) > Math.abs(curMaxShift.getY())) {
					maxShift.setY(curMaxShift.getY());
				}
			}
			if (maxShift.getX() > Integer.MAX_VALUE / 4.0) {
				maxShift.setX(player.getSpeed().getX());
			}
			if (maxShift.getY() > Integer.MAX_VALUE / 4.0) {
				maxShift.setY(player.getSpeed().getY());
			}
			player.setRealShift(new Vector(player.getPosition().getX() + maxShift.getX(),
					player.getPosition().getY() + maxShift.getY()));
		} else if (gameObject instanceof DynamicObstacle) {
			((DynamicObstacle) gameObject).updateSpeed();
		}
	}
	
	private void applyShift() {
		for (Obstacle obstacle : obstacles) {
			obstacle.applySpeed();
		}
		Vector playerOldPos = player.getPosition().copyOf();
		player.setPosition(player.getRealShift().copyOf());
		Vector newCameraPos = new Vector(0, 0);
		
		// strictly follow the player
		newCameraPos.setX(camera.getPosition().getX() + (player.getPosition().getX() - playerOldPos.getX()));
		camera.setPosition(newCameraPos);
//		ground.setPosition(new Vector(ground.getCollider().getPosition().getX() + (player.getPosition().getX() - playerOldPos.getX()), ground.getCollider().getPosition().getY()));
		
	}
	
	void jump() {
		player.jump();
	}
	
	void update() {
		System.err.print("");
		checkObstacles();
		checkPlayer();
		applyShift();
		System.err.print("");
	}
	
}
