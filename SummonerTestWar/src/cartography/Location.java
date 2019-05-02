package cartography;

public class Location {
	private int floor;
	private int x;
	private int y;
	private boolean inRoom;
	

	private String locationReport = "Your coordinates are " + floor + "F, at point (" + x + ", " + y + ").";



	public Location(int floor, int x, int y, boolean inRoom) {
		this.floor = floor;
		this.x = x;
		this.y = y;
		this.inRoom = inRoom;
		}

	public String toString() {
		String output = floor + "f, (" + x + ", " + y + ")";
		return output;
	}

	public boolean atStair() {
		if (this.y == 2) {
			return true;
		} else if (this.y == 5) {
			if (this.x == 0 || this.x == 3) {
				return true;
			}
		} else if (this.y == 4 && this.x == 3) {
			return true;
		} else {
			return false;
		}
		return false;
	}

	public boolean atRoom() {
		if (!this.atStair()) {
			if (this.floor == 1) {
				return true;
			}

			if (this.floor == 2) {
				if (this.x == 5 || this.y == 0) {
					return true;
				} else if ((this.x == 0 && this.y == 4) || (this.x == 1 && this.y == 5)) {
					return true;
				}
			}

			if (this.floor == 3) {
				if (this.x == 5 || this.y == 0) {
					return true;
				}
			}

			if (this.floor == 4) {
				if (this.x == 5 && this.y == 5) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean canMoveUp() {
		if (this.atStair() && this.floor < 4) {
			return true;
		}
		return false;
	}

	public boolean canMoveDown() {
		if (this.atStair() && this.floor > 1) {
			return true;
		}
		return false;
	}

	public boolean canMoveNorth() {
		if (this.y > 5) {
			if (this.x == 0 || this.x == 1 || this.x == 3 || this.x == 5) {
				return true;
			}
		}
		return false;
	}

	public boolean canMoveWest() {
		if (this.x > 0) {
			if (this.y == 0 || this.y == 1 || this.y == 3 || this.y == 5) {
				return true;
			}
		}
		return false;
	}

	public boolean canMoveSouth() {
		if (this.x <= 1 && this.y > 0) {
			return true;
		} else if ((this.atStair() || this.x == 5) && this.y > 4) {
			return true;
		}
		return false;
	}

	public boolean canMoveEast() {
		if (this.y >= 4 && this.x > 0) {
			return true;
		} else if ((this.atStair() || this.y == 0) && this.x > 0) {
			return true;
		}
		return false;
	}
	
	public String location() {
		if(inRoom) {
			return "Classroom. " + locationReport;
		}
		return "Hallway. " + locationReport;
	}

	public String moveNorth() {
		if (canMoveNorth() && !inRoom) {
			this.y += 1;
			return "Hallway. " + locationReport;
		}
		return "Can't move North!";
	}

	public String moveSouth() {
		if (canMoveSouth() && !inRoom) {
			this.y -= 1;
			return "Hallway. " + locationReport;
		}
		return "Can't move South!";
	}

	public String moveEast() {
		if (canMoveSouth() && !inRoom) {
			this.x += 1;
			return "Hallway. " + locationReport;
		}
		return "Can't move East!";
	}

	public String moveWest() {
		if (canMoveSouth() && !inRoom) {
			this.x -= 1;
			return "Hallway. " + locationReport;
		}
		return "Can't move West!";
	}

	public String enterRoom() {
		if (inRoom) {
			return "You are already in a classroom. " + locationReport;
		}
		if (this.atRoom()) {
			this.inRoom = true;
			return "Classroom. " + locationReport;
		}
		return "The door is locked!";
	}

	public String exitRoom() {
		if (!inRoom) {
			return "You aren't in a classroom. " + locationReport;
		} 
		else {
			this.inRoom = false;
			return "Hallway. " + locationReport;
		}
	}
}
