package de.agilecoders.wicket.markup.html.bootstrap.navigation;

import de.agilecoders.wicket.markup.html.bootstrap.behavior.AssertTagNameBehavior;
import de.agilecoders.wicket.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.markup.html.bootstrap.behavior.CssClassNameProvider;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;

/**
 * A Wicket panel component to draw and maintain a complete page navigator, meant to be easily added
 * to any PageableListView. A navigation which contains links to the first and last page, the
 * current page +- some increment and which supports paged navigation bars (@see
 * PageableListViewNavigationWithMargin).
 *
 * @author miha
 */
public class BootstrapPagingNavigator extends PagingNavigator {

    /**
     * position of pagination component
     */
    public enum Position implements CssClassNameProvider {
        Left, Centered, Right;

        @Override
        public String cssClassName() {
            return equals(Left) ? "" : "pagination-" + name().toLowerCase();
        }

        @Override
        public CssClassNameAppender newCssClassNameModifier() {
            return new CssClassNameAppender(this);
        }
    }

    private final Model<String> positionModel;

    /**
     * Construct.
     *
     * @param markupId The components markup id
     * @param pageable The pageable component the page links are referring to.
     */
    public BootstrapPagingNavigator(final String markupId, final IPageable pageable) {
        this(markupId, pageable, null);
    }

    /**
     * Construct.
     *
     * @param markupId      The components markup id
     * @param pageable      The pageable component the page links are referring to.
     * @param labelProvider The label provider for the link text.
     */
    public BootstrapPagingNavigator(final String markupId, final IPageable pageable, final IPagingLabelProvider labelProvider) {
        super(markupId, pageable, labelProvider);

        positionModel = Model.of(Position.Left.cssClassName());

        BootstrapBaseBehavior.addTo(this);

        add(new AssertTagNameBehavior("div"),
            new CssClassNameAppender("pagination"),
            new CssClassNameAppender(positionModel));
    }

    /**
     * sets the position of the pagination component
     *
     * @param position The position
     * @return this instance for chaining
     */
    public BootstrapPagingNavigator setPosition(Position position) {
        positionModel.setObject(position.cssClassName());
        return this;
    }
}
