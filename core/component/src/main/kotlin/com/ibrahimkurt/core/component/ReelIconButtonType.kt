package com.ibrahimkurt.core.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.ibrahimkurt.core.component.theme.MultiModReelComposeTheme
import com.ibrahimkurt.core.component.util.Constants.EMPTY_STRING

object ReelIconButtonType {
    @Composable
    fun reelIconButtonColor(
        containerColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
        contentColor: Color = MaterialTheme.colorScheme.primary,
    ): IconButtonColors = IconButtonDefaults.filledIconButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = containerColor,
        disabledContentColor = contentColor
    )

    @Composable
    fun ReelIconButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        shape: Shape = IconButtonDefaults.filledShape,
        colors: IconButtonColors = reelIconButtonColor(),
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        content: @Composable () -> Unit
    ) {
        FilledIconButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = colors,
            interactionSource = interactionSource,
            content = content,
            shape = shape,
        )
    }
}

@ReelPreview
@Composable
fun SADecrementButtonIconButtonPreview() {
    MultiModReelComposeTheme {
        ReelIconButtonType.ReelIconButton(
            onClick = {
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = EMPTY_STRING,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}