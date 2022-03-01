// Generated by view binder compiler. Do not edit!
package com.example.jotdown.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.jotdown.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class Example7CalendarDayBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView exSevenDateText;

  @NonNull
  public final TextView exSevenDayText;

  @NonNull
  public final TextView exSevenMonthText;

  @NonNull
  public final View exSevenSelectedView;

  private Example7CalendarDayBinding(@NonNull FrameLayout rootView,
      @NonNull TextView exSevenDateText, @NonNull TextView exSevenDayText,
      @NonNull TextView exSevenMonthText, @NonNull View exSevenSelectedView) {
    this.rootView = rootView;
    this.exSevenDateText = exSevenDateText;
    this.exSevenDayText = exSevenDayText;
    this.exSevenMonthText = exSevenMonthText;
    this.exSevenSelectedView = exSevenSelectedView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static Example7CalendarDayBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static Example7CalendarDayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.example_7_calendar_day, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static Example7CalendarDayBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.exSevenDateText;
      TextView exSevenDateText = ViewBindings.findChildViewById(rootView, id);
      if (exSevenDateText == null) {
        break missingId;
      }

      id = R.id.exSevenDayText;
      TextView exSevenDayText = ViewBindings.findChildViewById(rootView, id);
      if (exSevenDayText == null) {
        break missingId;
      }

      id = R.id.exSevenMonthText;
      TextView exSevenMonthText = ViewBindings.findChildViewById(rootView, id);
      if (exSevenMonthText == null) {
        break missingId;
      }

      id = R.id.exSevenSelectedView;
      View exSevenSelectedView = ViewBindings.findChildViewById(rootView, id);
      if (exSevenSelectedView == null) {
        break missingId;
      }

      return new Example7CalendarDayBinding((FrameLayout) rootView, exSevenDateText, exSevenDayText,
          exSevenMonthText, exSevenSelectedView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
