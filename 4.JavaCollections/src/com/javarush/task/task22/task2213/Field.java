package com.javarush.task.task22.task2213;

public class Field {//поле с клетками, отвечает за хранение данных о текущих занятых и свободных клетках на поле игры.

   private int width;
   private int height;

   private int[][] matrix;//матрица

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width]; //первой координатой в массиве у нас будет номер строки, а второй - столбца.
        //Двумерный массив можно представить как массив массивов или как прямоугольную матрицу.
        //При этом первой координатой в массиве у нас будет номер строки, а второй - столбца.
        //Другими словами ячейка с координатами x, y - это matrix[y][x].
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void print(){// объект будет отрисовывать на экран свое текущее состояние

    }
    public void removeFullLines(){//будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз;

    }
   public Integer getValue(int x, int y){// - возвращает значение которое находится в матрице с координатами x и y;
        return null;
    }
    public void setValue(int x, int y, int value){//устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y.

    }
}

