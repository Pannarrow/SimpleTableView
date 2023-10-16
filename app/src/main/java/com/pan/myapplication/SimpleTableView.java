package com.pan.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * @Description 简单的表格视图
 * @Author hongpan
 * @Date 2023/10/16 周一 11:13
 */
public class SimpleTableView extends LinearLayout {

    /**
     * 设置标题
     * @param firstTile firstTile
     * @param secondTile secondTile
     * @return this
     */
    public SimpleTableView setTitles(String firstTile, String secondTile) {
        this.firstTile = firstTile;
        this.secondTile = secondTile;
        return this;
    }

    /**
     * 设置行高
     * @param rowHeight rowHeight
     * @return this
     */
    public SimpleTableView setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
        return this;
    }

    /**
     * 设置第一列宽度比重
     * @param firstWeight firstWeight
     * @return this
     */
    public SimpleTableView setFirstWeight(float firstWeight) {
        this.firstWeight = firstWeight;
        return this;
    }

    /**
     * 设置第二列宽度比重
     * @param secondWeight firstWeight
     * @return this
     */
    public SimpleTableView setSecondWeight(float secondWeight) {
        this.secondWeight = secondWeight;
        return this;
    }

    /**
     * 设置文字颜色
     * @param textColor textColor
     * @return this
     */
    public SimpleTableView setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * 设置文字字号
     * @param textSize textSize
     * @return this
     */
    public SimpleTableView setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * 设置边框宽度
     * @param borderW borderW
     * @return this
     */
    public SimpleTableView setBorderW(float borderW) {
        this.borderW = borderW;
        return this;
    }

    /**
     * 设置边框颜色
     * @param borderColor borderColor
     * @return this
     */
    public SimpleTableView setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * 设置边框圆角
     * @param borderRadius borderRadius
     * @return this
     */
    public SimpleTableView setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    /**
     * 设置第一列文字左边距
     * @param firstPaddingLeft firstPaddingLeft
     * @return this
     */
    public SimpleTableView setFirstPaddingLeft(int firstPaddingLeft) {
        this.firstPaddingLeft = firstPaddingLeft;
        return this;
    }

    /**
     * 设置第二列文字左边距
     * @param secondPaddingLeft secondPaddingLeft
     * @return this
     */
    public SimpleTableView setSecondPaddingLeft(int secondPaddingLeft) {
        this.secondPaddingLeft = secondPaddingLeft;
        return this;
    }

    /**
     * 设置输入框光标
     * @param cursorDrawable cursorDrawable
     * @return this
     */
    public SimpleTableView setCursorDrawable(Drawable cursorDrawable) {
        this.cursorDrawable = cursorDrawable;
        return this;
    }

    private String firstTile;

    private String secondTile;

    private int rowHeight = 96;

    private float firstWeight = 3;

    private float secondWeight = 5;

    private int textColor = Color.BLACK;

    private int textSize = 36;

    private float borderW = 3;

    private int borderColor = Color.BLACK;

    private int borderRadius = 12;

    private int firstPaddingLeft = 27;

    private int secondPaddingLeft = 57;

    private Drawable cursorDrawable;

    /**
     * 刷新
     */
    public void refresh() {
        if (tableViews != null && tableViews.size() > 0) {
            for (int i = 0; i < tableViews.size(); i++) {
                List<View> views = tableViews.get(i);
                View view1 = views.get(0);
                if (view1 instanceof TextView) {
                    TextView textView = (TextView) view1;
                    LayoutParams layoutParams = (LayoutParams)textView.getLayoutParams();
                    layoutParams.weight = firstWeight;
                    layoutParams.height = rowHeight;
                    textView.setLayoutParams(layoutParams);
                    textView.setTextColor(textColor);
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                    textView.setPadding(firstPaddingLeft, 0, 0, 0);
                    if (i == 0) {
                        textView.setText(firstTile);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cursorDrawable != null) {
                            EditText editText = (EditText) view1;
                            editText.setTextCursorDrawable(cursorDrawable);
                        }
                    }
                }
                View view2 = views.get(1);
                if (view2 instanceof TextView) {
                    TextView textView = (TextView) view2;
                    LayoutParams layoutParams = (LayoutParams)textView.getLayoutParams();
                    layoutParams.weight = secondWeight;
                    layoutParams.height = rowHeight;
                    textView.setLayoutParams(layoutParams);
                    textView.setTextColor(textColor);
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                    textView.setPadding(secondPaddingLeft, 0, 0, 0);
                    if (i == 0) {
                        textView.setText(secondTile);
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cursorDrawable != null) {
                            EditText editText = (EditText) view2;
                            editText.setTextCursorDrawable(cursorDrawable);
                        }
                    }
                }
            }
        }

        // 重绘边框
        paint.setColor(borderColor);
        paint.setStrokeWidth(borderW);
        invalidate();
    }

    private List<List<View>> tableViews;

    private Paint paint;

    public SimpleTableView(Context context) {
        super(context);
        init();
    }

    public SimpleTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SimpleTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        tableViews = new ArrayList<>();
        setOrientation(VERTICAL);
        createTitleLayout();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(borderColor);
        paint.setStrokeWidth(borderW);
        paint.setStyle(Paint.Style.STROKE);
    }

    /**
     * 创建一行标题视图
     */
    private void createTitleLayout() {
        LinearLayout rowLayout = new LinearLayout(getContext());

        // 第一个标题
        TextView firstTv = new TextView(getContext());
        firstTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        firstTv.setTextColor(textColor);
        firstTv.setGravity(Gravity.CENTER_VERTICAL);
        firstTv.setPadding(firstPaddingLeft, 0, 0, 0);
        LinearLayout.LayoutParams firstLp = new LinearLayout.LayoutParams(0, rowHeight);
        firstLp.weight = firstWeight;
        rowLayout.addView(firstTv, firstLp);

        // 第二个标题
        TextView secondTv = new TextView(getContext());
        secondTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        secondTv.setTextColor(textColor);
        secondTv.setGravity(Gravity.CENTER_VERTICAL);
        secondTv.setPadding(secondPaddingLeft, 0, 0, 0);
        LinearLayout.LayoutParams secondLp = new LinearLayout.LayoutParams(0, rowHeight);
        secondLp.weight = secondWeight;
        rowLayout.addView(secondTv, secondLp);

        // 添加按钮
        ImageView addImg = new ImageView(getContext());
        LinearLayout.LayoutParams imgLp = new LinearLayout.LayoutParams(rowHeight, rowHeight);
        addImg.setImageResource(R.mipmap.ic_add_file);
        int padding = rowHeight / 4;
        addImg.setPadding(padding, padding, padding, padding);
        addImg.setScaleType(ImageView.ScaleType.FIT_XY);
        rowLayout.addView(addImg, imgLp);

        // 添加到父布局
        LinearLayout.LayoutParams rowLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        addView(rowLayout, rowLp);

        // 存储view便于修改
        List<View> titleLayout = new ArrayList<>();
        titleLayout.add(firstTv);
        titleLayout.add(secondTv);
        titleLayout.add(addImg);
        tableViews.add(titleLayout);
        addImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createInputLayout();
                invalidate();
            }
        });
    }

    /**
     * 创建一行输入视图
     */
    private void createInputLayout() {
        final LinearLayout rowLayout = new LinearLayout(getContext());

        // 第一个输入框
        EditText firstEdt = new EditText(getContext());
        firstEdt.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        firstEdt.setTextColor(textColor);
        firstEdt.setGravity(Gravity.CENTER_VERTICAL);
        firstEdt.setPadding(firstPaddingLeft, 0, 0, 0);
        firstEdt.setBackground(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cursorDrawable != null) {
            firstEdt.setTextCursorDrawable(cursorDrawable);
        }
        LayoutParams firstLp = new LayoutParams(0, rowHeight);
        firstLp.weight = firstWeight;
        rowLayout.addView(firstEdt, firstLp);

        // 第二个输入框
        EditText secondEdt = new EditText(getContext());
        secondEdt.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        secondEdt.setTextColor(textColor);
        secondEdt.setGravity(Gravity.CENTER_VERTICAL);
        secondEdt.setPadding(secondPaddingLeft, 0, 0, 0);
        secondEdt.setBackground(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cursorDrawable != null) {
            secondEdt.setTextCursorDrawable(cursorDrawable);
        }
        LayoutParams secondLp = new LayoutParams(0, rowHeight);
        secondLp.weight = secondWeight;
        rowLayout.addView(secondEdt, secondLp);

        // 删除按钮
        ImageView deleteImg = new ImageView(getContext());
        LayoutParams imgLp = new LayoutParams(rowHeight, rowHeight);
        rowLayout.addView(deleteImg, imgLp);
        deleteImg.setImageResource(R.mipmap.ic_menu_delete);
        int padding = rowHeight / 4;
        deleteImg.setPadding(padding, padding, padding, padding);
        deleteImg.setScaleType(ImageView.ScaleType.FIT_XY);

        // 添加到父布局
        LayoutParams rowLp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(rowLayout, rowLp);

        // 存储view便于修改
        final List<View> titleLayout = new ArrayList<>();
        titleLayout.add(firstEdt);
        titleLayout.add(secondEdt);
        titleLayout.add(deleteImg);
        tableViews.add(titleLayout);
        deleteImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(rowLayout);
                tableViews.remove(titleLayout);
            }
        });
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0 && this.rowHeight > 0) {
            // 外边框
            float v = borderW / 2;
            canvas.drawRoundRect(v, v, getMeasuredWidth() - v, getMeasuredHeight() - v, borderRadius, borderRadius, paint);
            // 行间隔
            int rowCount = getMeasuredHeight() / rowHeight;
            for (int i = 1; i < rowCount; i++) {
                canvas.drawLine(0, i * rowHeight, getMeasuredWidth(), i * rowHeight, paint);
            }
            // 列间隔
            float secondDiv = getMeasuredWidth() - rowHeight;
            float firstDiv = secondDiv * firstWeight / (firstWeight + secondWeight);
            canvas.drawLine(firstDiv, 0, firstDiv, getMeasuredHeight(), paint);
            canvas.drawLine(secondDiv, 0, secondDiv, getMeasuredHeight(), paint);
        }
    }
}
